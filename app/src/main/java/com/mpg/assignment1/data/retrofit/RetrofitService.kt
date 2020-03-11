package com.mpg.assignment1.data.retrofit

import com.mpg.assignment1.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {


    private fun getOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(logging).build()
    }

    fun getRetroService(): AppApiService {
        return getRetro().create(AppApiService::class.java)
    }

    private var retrofit: Retrofit? = null
    private fun getRetro(): Retrofit {
        return if (retrofit == null) {
            Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .baseUrl(BuildConfig.BASE_URL).build()
        } else retrofit as Retrofit
    }
}