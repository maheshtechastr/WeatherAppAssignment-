package com.mpg.assignment1.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpg.assignment1.data.Repositories

open class BaseViewModel : ViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()


    val repositories by lazy {
        Repositories()
    }


}