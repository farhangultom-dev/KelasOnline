package com.farhandev.kelasonline.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import com.farhandev.kelasonline.R
import com.farhandev.kelasonline.databinding.ActivityLoginBinding
import com.farhandev.kelasonline.network.ApiClient
import com.farhandev.kelasonline.network.response.login.LoginResponse

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var activityLoginBinding: ActivityLoginBinding
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding.root)

        presenter = LoginPresenter(this, ApiClient.getService())

//        activityLoginBinding.etEmail.setText("taufik@gmail.com")
//        activityLoginBinding.etPassword.setText("taufik@gmail.com")
    }

    override fun setupListener() {
        activityLoginBinding.btnLogin.setOnClickListener {
            val email = activityLoginBinding.etEmail.text.toString()
            val password = activityLoginBinding.etPassword.text.toString()

            presenter.fetchLogin(email,password)
        }
    }

    override fun loginLoading(loading: Boolean) {
        activityLoginBinding.btnLogin.isEnabled = loading.not()
        when(loading){
            true -> activityLoginBinding.btnLogin.text = "Tunggu..."
            false -> activityLoginBinding.btnLogin.text = "Masuk"
        }
    }

    override fun loginResponse(response: LoginResponse) {
        when(response.status){
            true -> Toast.makeText(applicationContext, response.msg, Toast.LENGTH_SHORT).show()
            false -> Toast.makeText(applicationContext, response.msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun loginError(message: String) {
        runOnUiThread {
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
    }
}