package com.mpg.assignment1.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mpg.assignment1.R
import com.mpg.assignment1.ui.adapter.WeatherListAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, weatherListAdapter: WeatherListAdapter) {
    recyclerView.adapter = weatherListAdapter
}
//String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
//Picasso.with(context).load(iconUrl).into(yourImageView);
@BindingAdapter("setIcon")
fun loadWeatherIcon(imageView: ImageView, icon:String){
    val iconUrl = "http://openweathermap.org/img/w/$icon.png"
//    Glide.load(iconUrl)
//        .centerCrop()
//        .placeholder(R.drawable.loading_spinner)
//        .into(myImageView);
//    Glide.with(imageView.context).load(iconUrl).centerCrop().into(imageView)
}
@BindingAdapter("date")
fun setDate(textView:TextView, date:Long){
    val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    textView.text =     sdf.format(Date(date*1000))
}

//private fun getDateTime(s: String): String? {
//    try {
//
//        val sdf = SimpleDateFormat("MM/dd/yyyy")
//        val netDate = Date(Long.parseLong(s))
//        return sdf.format(netDate)
//    } catch (e: Exception) {
//        return e.toString()
//    }
//}