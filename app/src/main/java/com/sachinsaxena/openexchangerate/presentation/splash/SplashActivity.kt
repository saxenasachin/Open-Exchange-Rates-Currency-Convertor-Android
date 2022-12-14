package com.sachinsaxena.openexchangerate.presentation.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.sachinsaxena.openexchangerate.databinding.ActivitySplashBinding
import com.sachinsaxena.openexchangerate.presentation.main.activity.CurrencyConvertorActivity

/**
Created by Sachin Saxena on 29/09/22.
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToMainActivity()
    }

    private fun goToMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            CurrencyConvertorActivity.getStartIntent(this).apply {
                startActivity(this)
            }
            finish()
        },
            SPLASH_WAITING_TIME
        )
    }

    companion object {
        private const val SPLASH_WAITING_TIME = 500L // 2 seconds.
    }
}