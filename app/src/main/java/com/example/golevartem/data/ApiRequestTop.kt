package com.example.golevartem.data

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiRequestTop  {

    //TOP_100_POPULAR_FILMS
    @Headers("X-API-KEY: e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
    @GET("/api/v2.2/films/top/")
    suspend fun getFilms(@Query("type") type: String): List<FilmItem>

    @GET("/api/v2.2/films/top/<id фильма>")
    suspend fun getOneFilm(@Query("id") id: Int): FilmItem
}