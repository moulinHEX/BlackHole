package com.rogue.mvvmsample.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rogue.mvvmsample.data.User
import com.rogue.mvvmsample.data.UserRepository

class HomeViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getUsers(): MutableLiveData<List<User>> = userRepository.getUsers()
}