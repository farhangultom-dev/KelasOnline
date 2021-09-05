package com.farhandev.kelasonline.ui.login

import com.farhandev.kelasonline.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginPresenter(private val view: LoginView, private val api: ApiService) {
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
}