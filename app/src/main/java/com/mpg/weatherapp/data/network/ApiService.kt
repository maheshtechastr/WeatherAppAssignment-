package com.mpg.weatherapp.data.network


import com.mpg.weatherapp.BuildConfig.APP_ID
import com.mpg.weatherapp.BuildConfig.BASE_URL
import com.mpg.weatherapp.model.WeatherResponseModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("weather")
    fun getCurrentWeatherByZip(@Query("zip") zip: String, @Query("appid") appid: String = APP_ID): Observable<WeatherResponseModel>


    @GET("forecast")
    fun getWeeklyWeatherByZip(@Query("zip") zip: String, @Query("appid") appid: String = APP_ID,
                              @Query("cnt") count:Int = 7):
            Observable<List<WeatherResponseModel>>
/*
*
*  @GET("/data/{version}/forecast/daily")
    fun getWeatherDataList(@Query("zip") zipCodeAndCountryCode:String,
                               @Query("appid") appId:String,
                                   @Query("cnt") count:Int): Observable<List<WeatherModel>>*/

    companion object {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): ApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}