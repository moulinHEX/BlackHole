package com.rogue.mvvmsample.data.network

import com.rogue.mvvmsample.data.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}