package com.sachinsaxena.common.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
Created by Sachin Saxena on 29/09/22.
 */
fun ImageView.loadImageEtx(
    url: String?,
    onLoadFailed: ((Boolean) -> Unit)? = null,
    onResourceReady: ((Boolean) -> Unit)? = null
) {
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .format(DecodeFormat.PREFER_RGB_565)
        .addListener(object : RequestListener<Drawable> {

            override fun onLoadFailed(
                e: GlideException?, model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean,
            ): Boolean {
                onLoadFailed?.invoke(true)
                return true
            }

            override fun onResourceReady(
                resource: Drawable?, model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?, isFirstResource: Boolean,
            ): Boolean {
                onResourceReady?.invoke(true)
                return false
            }
        })
        .into(this)
}