package com.rogue.mvvmsample.di

import com.google.gson.Gson
import com.rogue.mvvmsample.BuildConfig
import com.rogue.mvvmsample.data.network.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideUserService(): UserService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(UserService::class.java)
    }
}