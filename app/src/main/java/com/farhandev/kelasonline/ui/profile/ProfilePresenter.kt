package com.farhandev.kelasonline.ui.profile

import com.farhandev.kelasonline.network.response.login.Data
import com.farhandev.kelasonline.preference.PrefManager
import com.google.gson.Gson

class ProfilePresenter(
    private val view: ProfileView,
    private val pref: PrefManager
) {

    init {
        view.user(user())
    }

    private fun user(): Data{
        val json = pref.getString("user_login")
        return Gson().fromJson(json, Data::class.java)
    }

    fun logout(){
        pref.clear()
        view.logout()
    }
}