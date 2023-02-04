package com.example.golevartem.domain

import com.example.golevartem.data.FilmItem
import com.example.golevartem.data.FilmRepositoryImpl

class GetFilmUseCase(private val filmRepository: FilmRepository) {

    suspend fun getOneFilm(id: Int): FilmItem{
        val films = filmRepository.getFilms()
        return films[id]
    }

}