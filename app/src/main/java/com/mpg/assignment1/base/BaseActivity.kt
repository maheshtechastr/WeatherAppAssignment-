package com.mpg.assignment1.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<VM: BaseViewModel, VB : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewModelActivity: VM

    lateinit var viewBinding: VB

    abstract fun viewLayoutId(): Int

    abstract fun onCreate()
    abstract fun viewModel(): Class<VM>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, viewLayoutId())
        viewModelActivity = ViewModelProviders.of(this).get(viewModel())

        onCreate()
    }
}