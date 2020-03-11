package com.mpg.assignment1.data

import androidx.lifecycle.MutableLiveData
import com.mpg.assignment1.data.models.WeatherModel
import com.mpg.assignment1.data.models.WeatherModelList
import com.mpg.assignment1.data.retrofit.AppApiService
import com.mpg.assignment1.data.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repositories {

    private val appApiService: AppApiService by lazy {
        RetrofitService.getRetroService()
    }

    val weatherLiveDataList: MutableLiveData<WeatherModelList> = MutableLiveData()
    val weatherLiveData: MutableLiveData<WeatherModel> = MutableLiveData()

    fun getDailyWeather(zipCode: String, appId: String) {
        appApiService.getDailyWeather(zipCode, appId)
            .enqueue(object : Callback<WeatherModel> {
                override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<WeatherModel>,
                    response: Response<WeatherModel>
                ) {
                    weatherLiveData.value = response.body()
                }
            })
    }

    fun getWeeklyWeather(zipCode: String, appId: String) {
        appApiService.getWeeklyWeather(zipCode, appId)
            .enqueue(object : Callback<WeatherModelList> {
                override fun onFailure(call: Call<WeatherModelList>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<WeatherModelList>,
                    response: Response<WeatherModelList>
                ) {
                    weatherLiveDataList.value = response.body()
                }
            })
    }
}
