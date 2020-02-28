package com.mpg.weatherapp.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpg.weatherapp.data.network.StatusCode
import com.mpg.weatherapp.data.repository.ForecastRepository

import com.mpg.weatherapp.model.WeatherResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ForecastViewModel(val repository: ForecastRepository) : ViewModel() {
    val TAG = ForecastViewModel::class.java.simpleName
    var currentWeather: MutableLiveData<WeatherResponseModel> = MutableLiveData()


    @SuppressLint("CheckResult")
    fun getCurrentWeather(zip: String) {
        val responseModel = WeatherResponseModel()

        repository.getCurrentWeather(zip)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                responseModel.statusCode = StatusCode.START
                currentWeather.value = responseModel
            }
            .observeOn(AndroidSchedulers.mainThread())
            //below code is working on Main thread
            .subscribe(
                { success ->
                    success.statusCode = StatusCode.SUCCESS
                    currentWeather.value = success
                    Log.d(TAG, "success${currentWeather.value?.base}")
                }, { error ->
                    Log.d(TAG, "api error ${error.message}")
                    responseModel.msg = error.localizedMessage!!
                    responseModel.statusCode = StatusCode.ERROR
                    currentWeather.value = responseModel
                })
    }



}