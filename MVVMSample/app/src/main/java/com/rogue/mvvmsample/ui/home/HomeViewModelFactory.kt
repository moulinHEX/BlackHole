package com.rogue.mvvmsample.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rogue.mvvmsample.data.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModelFactory @Inject constructor(private val userRepository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == HomeViewModel::class.java) {
            return HomeViewModel(userRepository) as T
        }
        throw IllegalArgumentException("unknown class $modelClass")
    }
}