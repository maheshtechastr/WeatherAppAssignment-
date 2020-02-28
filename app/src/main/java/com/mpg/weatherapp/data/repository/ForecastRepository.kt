package com.mpg.weatherapp.data.repository

import com.mpg.weatherapp.data.network.ApiService
import com.mpg.weatherapp.model.WeatherResponseModel
import io.reactivex.Observable

class ForecastRepository(private val api: ApiService) {

    fun getCurrentWeather(zip: String): Observable<WeatherResponseModel> {
        return api.getCurrentWeatherByZip(zip)
    }

    fun getWeeklyWeather(zip: String): Observable<List<WeatherResponseModel>> {
        return api.getWeeklyWeatherByZip(zip)
    }

}