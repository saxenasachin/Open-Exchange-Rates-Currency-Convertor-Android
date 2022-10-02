package com.sachinsaxena.paypay.utils

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.annotation.RequiresPermission

object NetworkUtils {

    fun isConnected(context: Context): Boolean {
        val info = getActiveNetworkInfo(context)
        return info?.isConnected ?: false
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun getActiveNetworkInfo(context: Context): NetworkInfo? {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return manager.activeNetworkInfo
    }
}