package com.farhandev.kelasonline.ui.splashscreen

import com.farhandev.kelasonline.preference.PrefManager

class SplashPresenter(
    private val view: SplashView,
    private val pref: PrefManager
) {
    init {
        view.nextPage(pref.getInt("is_login"))
    }
}