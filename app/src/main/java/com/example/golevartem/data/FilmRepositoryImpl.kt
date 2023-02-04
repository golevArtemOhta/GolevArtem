package com.example.golevartem.data

import com.example.golevartem.data.network.RetrofitFactory
import com.example.golevartem.domain.FilmRepository

object FilmRepositoryImpl: FilmRepository {

    private val api = RetrofitFactory.getFilmsApiService()

    override suspend fun getFilms(): List<FilmItem> {
        val films = api.getFilms("TOP_100_POPULAR_FILMS")
        return films.films
    }
}