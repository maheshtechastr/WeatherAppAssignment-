package com.mpg.weatherapp.app

import android.app.Application
import com.mpg.weatherapp.data.network.ApiService
import com.mpg.weatherapp.data.network.NetworkConnectionInterceptor
import com.mpg.weatherapp.data.repository.ForecastRepository
import com.mpg.weatherapp.ui.viewmodel.ForecastViewModelFactory

import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApp : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApp))

        //use operator fun in singleton classes mostly act as a constructor
        bind() from singleton {
            NetworkConnectionInterceptor(
                instance()
            )
        }
        bind() from singleton {
            ApiService(
                instance()
            )
        }
        bind() from singleton {
            ForecastRepository(
                instance()
            )
        }

        bind() from provider {
            ForecastViewModelFactory(
                instance()
            )
        }
    }
}
