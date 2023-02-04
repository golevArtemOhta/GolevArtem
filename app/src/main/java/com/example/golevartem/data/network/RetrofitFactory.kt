package com.example.golevartem.data.network

import com.example.golevartem.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

   /* fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor;
    }

    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthInterceptor(BuildConfig.API_KEY))
            .build()
    } */

    /*fun getFilmsApiService(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(FilmApiService::class.java) */

    fun getFilmsApiService() = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FilmApiService::class.java)

}