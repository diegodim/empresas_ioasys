package com.diego.duarte.base_feature.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.Downsampler
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.loadUrl(url: String?){

    if(url.isNullOrBlank()) return

    Glide.with(this.context)
        .load(url)
        .centerInside()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .set(Downsampler.DECODE_FORMAT, DecodeFormat.PREFER_RGB_565)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)

}