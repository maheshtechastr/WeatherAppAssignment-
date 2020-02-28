package com.mpg.weatherapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mpg.weatherapp.R

import com.mpg.weatherapp.databinding.ActivityWeatherBinding
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.activity_weather.view.*

class WeatherActivity : AppCompatActivity() {
    private lateinit var bindingView: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingView = DataBindingUtil.setContentView(this,
            R.layout.activity_weather
        )

        init()
    }

    /**
     * inital setUps
     */
    private fun init() {
        val findNavController = findNavController(R.id.nav_host_fragment)

        // Setup Action Bar
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(findNavController)

        // Setup Toolbar
        toolbar.setupWithNavController(findNavController)

        toolbar.title = ""
        toolbar.toolbar_title.text = getString(R.string.txt_title_forecast)
    }


}
