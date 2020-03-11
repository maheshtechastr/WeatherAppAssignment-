package com.mpg.assignment1.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

abstract class BaseFragment<VM : BaseViewModel, VB : ViewDataBinding> : Fragment() {

    lateinit var viewModel: VM
    lateinit var viewBinding: VB

    val TAG: String = BaseFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(provideViewModel())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)

        return viewBinding.root
    }

    abstract fun provideViewModel(): Class<VM>

    abstract fun layoutId(): Int
}