package com.mpg.assignment1.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mpg.assignment1.base.BaseViewModel

class MainActivityViewModel : BaseViewModel() {

    val pageTitle: MutableLiveData<String> = MutableLiveData()

}