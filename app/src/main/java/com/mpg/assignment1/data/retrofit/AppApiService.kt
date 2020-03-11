package com.mpg.assignment1.data.retrofit

import com.mpg.assignment1.data.models.WeatherModel
import com.mpg.assignment1.data.models.WeatherModelList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApiService {

    @GET("/data/2.5/weather")
    fun getDailyWeather(
        @Query("zip") zipCodeWithCounty: String,
        @Query("appid") appId: String
    ): Call<WeatherModel>

    @GET("/data/2.5/forecast")
    fun getWeeklyWeather(
        @Query("zip") zipCodeWithCounty: String,
        @Query("appid") appId: String,
        @Query("cnt") count: Int = 7
    ): Call<WeatherModelList>
}