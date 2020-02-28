package com.mpg.weatherapp.ui.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mpg.weatherapp.R

import com.mpg.weatherapp.data.network.ApiService
import com.mpg.weatherapp.data.network.NetworkConnectionInterceptor
import com.mpg.weatherapp.data.network.StatusCode
import com.mpg.weatherapp.data.repository.ForecastRepository
import com.mpg.weatherapp.databinding.FragmentForecastBinding
import com.mpg.weatherapp.model.WeatherResponseModel
import com.mpg.weatherapp.ui.viewmodel.ForecastViewModel
import com.mpg.weatherapp.ui.viewmodel.ForecastViewModelFactory
import com.mpg.weatherapp.utils.Utils

import kotlinx.android.synthetic.main.fragment_forecast.*


/**
 * A simple [Fragment] subclass.
 */
class ForecastFragment : Fragment() {

    private val TAG = ForecastFragment::class.java.simpleName

    val zip = "110030,IN"
    val city  = "New Delhi"
    val Country = "India"

    private val viewModel: ForecastViewModel by lazy {
        ViewModelProvider(
            this,
            ForecastViewModelFactory(
                ForecastRepository(
                    ApiService.invoke(NetworkConnectionInterceptor(context!!))
                )
            )
        ).get(ForecastViewModel::class.java)
    }
    private lateinit var binding: FragmentForecastBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_forecast, container, false
            )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    /**
     * init
     */
    private fun init() {
        viewModel.getCurrentWeather("110030,IN")
        observeCurrentWeatherByZip()
    }

    private fun observeCurrentWeatherByZip() {
        viewModel.currentWeather.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer { success ->
                when (success?.statusCode) {
                    StatusCode.START -> {
                        Utils.hideKeyPad(activity!!)
                        progress_bar.visibility = View.VISIBLE
                    }
                    StatusCode.SUCCESS -> {
                        progress_bar.visibility = View.GONE
                        setData(success)
                        Log.d("DEBUG", "Base ${success.base.toString()}")

                    }
                    StatusCode.ERROR -> {
                        progress_bar.visibility = View.GONE
                        Utils.showToast(context!!, success.msg)
                    }
                }
            })

    }


    private fun setData(data: WeatherResponseModel) {
        val str = "${city}, ${Country}"
        cityText.text = str
        condDescr.text = data.weather?.get(0)?.description
        temp.text = data.main?.temp.toString()
        press.text = data.main?.pressure.toString()
        hum.text = data.main?.humidity.toString()
        windSpeed.text = data.wind?.speed.toString()
        windDeg.text = data.wind?.deg.toString()
    }

}
