package com.farhandev.kelasonline.ui.login

import com.farhandev.kelasonline.network.response.login.LoginResponse

interface LoginView {
    fun setupListener()
    fun loginLoading(loading: Boolean)
    fun loginResponse(response: LoginResponse)
    fun loginError(message: String)
}