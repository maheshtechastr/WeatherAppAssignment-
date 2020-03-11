package com.mpg.assignment1.data.models

import com.google.gson.annotations.SerializedName

data class WeatherModelList(
    val message: Int,
    val cod: String,
    var cnt: Int,
    val city: City,
    @SerializedName("list") val weatherList: List<WeatherListItem>
)

data class Clouds(val all: Int)

data class Sys(val pod: String)

data class Wind(val speed: Double, val deg: Int)

data class WeatherListItem(
    @SerializedName("dt_txt")val dtTxt: String,
    val dt: Long,
    val sys: Sys,
    val clouds: Clouds,
    val main: Main,
    val wind: Wind,
    @SerializedName("weather")val weatherList: List<Weather>
)

data class City(
    val city: String,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int,
    val coord: Coord
)

data class Coord(val lat: Double, val lon: Double)