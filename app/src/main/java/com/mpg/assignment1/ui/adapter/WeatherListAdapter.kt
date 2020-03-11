package com.mpg.assignment1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mpg.assignment1.R
import com.mpg.assignment1.data.models.WeatherListItem
import com.mpg.assignment1.databinding.WeatherListItemBinding
import com.mpg.assignment1.viewmodel.WeatherListItemViewModel

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {
    private lateinit var postList: List<WeatherListItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: WeatherListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.weather_list_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if (::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList: List<WeatherListItem>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: WeatherListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = WeatherListItemViewModel()

        fun bind(post: WeatherListItem) {
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }
}