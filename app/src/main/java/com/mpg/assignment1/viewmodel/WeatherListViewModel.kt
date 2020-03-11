package com.mpg.assignment1.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mpg.assignment1.BuildConfig
import com.mpg.assignment1.base.BaseViewModel
import com.mpg.assignment1.data.models.WeatherModelList
import com.mpg.assignment1.ui.adapter.WeatherListAdapter

class WeatherListViewModel : BaseViewModel() {

    val weatherListAdapter: WeatherListAdapter by lazy {
        WeatherListAdapter()
    }

    val weatherModelList: MutableLiveData<WeatherModelList> by lazy {
        repositories.weatherLiveDataList
    }

    init {
        repositories.getWeeklyWeather("110096,IN", BuildConfig.APP_ID)
    }
}