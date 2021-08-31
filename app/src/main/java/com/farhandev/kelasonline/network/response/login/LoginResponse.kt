package com.farhandev.kelasonline.network.response.login

data class LoginResponse(
	val msg: String,
	val data: Data?,
	val status: Boolean
)

data class Data(
	val password: String,
	val gender: String,
	val phone: String,
	val name: String,
	val id: Int,
	val avatar: String,
	val email: String
)
