package com.example.golevartem.domain

import com.example.golevartem.data.FilmItem
import com.example.golevartem.data.RetrofitFactory

class GetFilmUseCase {

    private val api = RetrofitFactory.getFlimsList()

    suspend fun getOneFilm(id: Int): FilmItem{
        val film = api.getOneFilm(id)
        return film
    }

}