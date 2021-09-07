package com.farhandev.kelasonline.ui.profile

import com.farhandev.kelasonline.network.response.login.Data

interface ProfileView {
    fun setUpListener()
    fun user(user: Data)
    fun logout()
}