package com.demo.mycomposeapplication.di

import com.demo.mycomposeapplication.ApiService
import com.demo.mycomposeapplication.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun okhttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->

            chain.proceed(chain.request().newBuilder().apply {
                header(
                    "X-Master-Key",
                    "$2a$10"+"$"+"b5HF6QN2ugFEG8c8wl8iLuiosEUe/L5LynmQeZQUlxCyP6RC0RXPG"
                )
                header("X-Bin-Meta", "false")
                header("Content-Type", "application/json")
                header("Accept", "application/json")
            }.build())

        }.also {
            if (BuildConfig.DEBUG){
                it.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
        }.build()
    }

    @Provides
    @Singleton
    fun buildRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io")
            .client(okhttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun apiService(): ApiService =
        buildRetrofit().create(ApiService::class.java)


}