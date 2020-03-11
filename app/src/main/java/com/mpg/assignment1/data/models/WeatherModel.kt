package com.mpg.assignment1.data.models

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    val name: String, val id: Int, val base: String, var main: Main,
    val visibility: Int, val weatherList: List<Weather>,
    val wind: Wind,
    val dt: Long,
    val clouds: Clouds,
    val sys: Sys
)

data class Weather(val id: Int, val main: String, val description: String, val icon: String)


data class Main(
    val temp: Float,
    @SerializedName("feels_like") val feelsLike: Float,

    @SerializedName("temp_min") val tempMin: Float,
    @SerializedName("temp_max") val tempMax: Float,
    val pressure: Int,
    @SerializedName("sea_level")val seaLevel: Int=0,
    @SerializedName("grnd_level")val grndLevel: Int=0,
    val humidity: Int
)
