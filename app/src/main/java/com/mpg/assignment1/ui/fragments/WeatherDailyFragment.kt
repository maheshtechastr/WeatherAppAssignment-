package com.mpg.assignment1.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.mpg.assignment1.R
import com.mpg.assignment1.base.BaseFragment
import com.mpg.assignment1.databinding.FragmentWeatherDailyBinding
import com.mpg.assignment1.viewmodel.MainActivityViewModel
import com.mpg.assignment1.viewmodel.WeatherDailyViewModel

class WeatherDailyFragment : BaseFragment<WeatherDailyViewModel, FragmentWeatherDailyBinding>() {

    private val mainActivityViewModel : MainActivityViewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun provideViewModel(): Class<WeatherDailyViewModel> {
        return WeatherDailyViewModel::class.java
    }

    override fun layoutId(): Int {
        return R.layout.fragment_weather_daily
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivityViewModel.pageTitle.postValue( "Weather Daily Report")

        viewBinding.viewModel = viewModel
        viewBinding.lifecycleOwner = this
        viewModel.loadingVisibility.value = View.VISIBLE

        viewModel.weatherLiveData.observe(viewLifecycleOwner, Observer {
            viewModel.loadingVisibility.value = View.GONE
        })

        viewBinding.weeklyWeatherList.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_weatherListFragment,
            bundleOf(
                "screenName" to "Main",
                "category" to 100
            ))
        }
    }
}
