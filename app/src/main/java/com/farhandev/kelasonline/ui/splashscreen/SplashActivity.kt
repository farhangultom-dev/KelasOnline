package com.farhandev.kelasonline.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.farhandev.kelasonline.ui.BaseActivity
import com.farhandev.kelasonline.R
import com.farhandev.kelasonline.preference.PrefManager
import com.farhandev.kelasonline.ui.home.HomeActivity
import com.farhandev.kelasonline.ui.login.LoginActivity

class SplashActivity : BaseActivity(),SplashView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        SplashPresenter(this, PrefManager(this))
    }

    override fun nextPage(isLogin: Int) {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (isLogin == 1) startActivity(Intent(this,HomeActivity::class.java))
            else startActivity(Intent(this, LoginActivity::class.java))
        },2000)
    }
}