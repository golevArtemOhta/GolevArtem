package com.example.golevartem.domain

import com.example.golevartem.data.FilmItem

interface FilmListRepository {
    suspend fun getFilmList(): List<FilmItem>
}