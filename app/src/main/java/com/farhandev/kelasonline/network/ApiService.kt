package com.farhandev.kelasonline.network

import com.farhandev.kelasonline.network.response.login.LoginResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    ): Response<LoginResponse>
}