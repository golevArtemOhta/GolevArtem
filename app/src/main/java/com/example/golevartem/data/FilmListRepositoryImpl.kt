package com.example.golevartem.data

import com.example.golevartem.domain.FilmListRepository

class FilmListRepositoryImpl: FilmListRepository {

    private val api = RetrofitFactory.getFlimsList()


    override suspend fun getFilmList(): List<FilmItem> {
        val films = api.getFilms("TOP_100_POPULAR_FILMS")
        return films
    }
}