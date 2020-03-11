package com.mpg.assignment1.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mpg.assignment1.R
import com.mpg.assignment1.base.BaseFragment
import com.mpg.assignment1.databinding.FragmentWeatherWeeklyBinding
import com.mpg.assignment1.extentions.showToast
import com.mpg.assignment1.viewmodel.MainActivityViewModel
import com.mpg.assignment1.viewmodel.WeatherListViewModel


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 *
 */
class WeatherListFragment : BaseFragment<WeatherListViewModel, FragmentWeatherWeeklyBinding>() {

    override fun provideViewModel(): Class<WeatherListViewModel> {
        return WeatherListViewModel::class.java
    }

    private val mainActivityViewModel : MainActivityViewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_weather_weekly
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.viewModelList = viewModel

        viewModel.loadingVisibility.value = View.VISIBLE

        viewBinding.lifecycleOwner = this

        mainActivityViewModel.pageTitle.postValue( "Weather Weekly report")

        viewModel.weatherModelList.observe(viewLifecycleOwner, Observer { weatherListModel ->

            viewModel.weatherListAdapter.updatePostList(weatherListModel.weatherList)

            viewModel.loadingVisibility.value = View.GONE
        })
        context?.showToast("From Weather List Fragment")

    }

}
