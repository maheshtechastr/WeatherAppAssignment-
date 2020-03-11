package com.mpg.assignment1.viewmodel

import com.mpg.assignment1.BuildConfig
import com.mpg.assignment1.base.BaseViewModel

class WeatherDailyViewModel : BaseViewModel() {

    val weatherLiveData by lazy {
        repositories.weatherLiveData
    }

    init {
        repositories.getDailyWeather("110096,IN", BuildConfig.APP_ID)
    }
}
