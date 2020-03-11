package com.mpg.assignment1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mpg.assignment1.data.Repositories

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val repositories: Repositories) : ViewModelProvider.NewInstanceFactory() {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return if (modelClass === WeatherDailyViewModel::class.java)
//            WeatherDailyViewModel(repositories) as T
//        else modelClass.newInstance()
//    }
}