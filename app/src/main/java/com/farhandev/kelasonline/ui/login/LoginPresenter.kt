package com.farhandev.kelasonline.ui.login

import com.farhandev.kelasonline.network.ApiService
import com.farhandev.kelasonline.network.response.login.Data
import com.farhandev.kelasonline.preference.PrefManager
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginPresenter(private val view: LoginView, private val api: ApiService, private val pref: PrefManager) {

    init {
        view.setupListener()
    }

    fun fetchLogin(email: String, password: String){
        view.loginLoading(true)
        GlobalScope.launch {
            val response = api.login(email,password)
            if (response.isSuccessful){
                withContext(Dispatchers.Main){
                    view.loginResponse(response.body()!!)
                    view.loginLoading(false)
                }
            }else{
                view.loginError(response.message())
            }
        }
    }

    fun saveLogin(data: Data){
        pref.put("is_login",1)
        pref.put("user_login", Gson().toJson(data))
    }
}