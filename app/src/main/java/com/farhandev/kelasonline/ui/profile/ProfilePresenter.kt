package com.farhandev.kelasonline.ui.profile

import com.farhandev.kelasonline.preference.PrefManager

class ProfilePresenter(
    private val view: ProfileView,
    private val pref: PrefManager
) {
    fun logout(){
        pref.clear()
        view.logout()
    }
}