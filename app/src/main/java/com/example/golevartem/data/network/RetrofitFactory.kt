package com.example.golevartem.data.network

import com.example.golevartem.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun getFilmsApiService() = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FilmApiService::class.java)

}