package com.farhandev.kelasonline.network

import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    )
}