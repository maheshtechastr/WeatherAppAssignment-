package com.mpg.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mpg.weatherapp.R

import com.mpg.weatherapp.databinding.WeatherItemBinding
import com.mpg.weatherapp.model.Weather

import com.mpg.weatherapp.ui.viewmodel.WeatherViewModel

class WeatherListAdapter: RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {
    private lateinit var postList:List<Weather>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: WeatherItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.weather_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList:List<Weather>){
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: WeatherItemBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = WeatherViewModel()

        fun bind(post:Weather){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }
}