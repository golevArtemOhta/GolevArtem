package com.example.golevartem.data.network

import com.example.golevartem.data.model.FilmItem
import com.example.golevartem.data.FilmsTop
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmApiService  {

    @Headers("X-API-KEY: e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
    @GET("/api/v2.2/films/top/")
    suspend fun getFilms(@Query("type") type: String, @Query("page") page: Int): FilmsTop

    @Headers("X-API-KEY: e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
    @GET("/api/v2.2/films/{id}/")
    suspend fun getFilm(@Path("id") id: Int): FilmItem
}