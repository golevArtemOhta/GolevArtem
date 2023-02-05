package com.example.golevartem.data

import com.example.golevartem.data.model.FilmItem

data class FilmsTop(
    val films: List<FilmItem>,
    val pagesCount: Int
)