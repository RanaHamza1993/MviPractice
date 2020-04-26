package com.havelisolutions.mvipractice.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.havelisolutions.mvipractice.R

fun provideRequestOptions(): RequestOptions {
    return RequestOptions.placeholderOf(R.drawable.white_background)
        .error(R.drawable.white_background)
}

//for loading image using databinding from server url
@BindingAdapter("image")
fun loadImage(view: ImageView,url:String?){
    Glide.with(view)
        .setDefaultRequestOptions(provideRequestOptions())
        .load(url)
        .into(view)
}
//for loading image using databinding from drawable resource

@BindingAdapter("drawable")
fun loadImage(view: ImageView,resource:Int?){
    Glide.with(view)
        .setDefaultRequestOptions(provideRequestOptions())
        .load(resource)
        .into(view)

}