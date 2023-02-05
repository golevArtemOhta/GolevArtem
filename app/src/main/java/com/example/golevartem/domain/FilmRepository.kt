package com.example.golevartem.domain

import com.example.golevartem.data.FilmItem

interface FilmRepository {
    suspend fun getFilms(page: Int): List<FilmItem>

    suspend fun getFilm(id: Int): FilmItem
}