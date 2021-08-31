package com.farhandev.kelasonline.ui.splashscreen

class SplashPresenter(
    private val view: SplashView
) {
    init {
        view.nextPage(0)
    }
}