package com.rogue.mvvmsample.data

import androidx.lifecycle.MutableLiveData
import com.rogue.mvvmsample.data.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userService: UserService){
    private val userLiveData: MutableLiveData<List<User>> = MutableLiveData()

    fun getUsers(): MutableLiveData<List<User>> {
        val users = mutableListOf<User>()
        userService.getUsers().enqueue(object: Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        users.addAll(it)
                        userLiveData.value = it
                    }
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                userLiveData.value = null
            }
        })
        return userLiveData
    }
}