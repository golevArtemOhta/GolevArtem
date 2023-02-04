package com.example.golevartem.domain

import com.example.golevartem.data.FilmItem

interface FilmRepository {
    suspend fun getFilms(): List<FilmItem>
}