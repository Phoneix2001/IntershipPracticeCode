package com.kamikaze.firstkotlinprogram.di

import com.kamikaze.firstkotlinprogram.retrofit.QuotesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {
    @Provides
    fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://quotable.io").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getQuotesAPI(retrofit: Retrofit):QuotesApi{
        return retrofit.create(QuotesApi::class.java)
    }
}