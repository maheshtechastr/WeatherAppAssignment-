package com.mpg.assignment1.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mpg.assignment1.base.BaseViewModel
import com.mpg.assignment1.data.models.WeatherListItem

class WeatherListItemViewModel : BaseViewModel() {
    val weatherDataItem: MutableLiveData<WeatherListItem> = MutableLiveData()

    fun bind(weatherListItem: WeatherListItem){
        weatherDataItem.value = weatherListItem;
    }
}