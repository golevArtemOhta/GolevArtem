package com.example.golevartem.data

import com.example.golevartem.data.model.Country
import com.example.golevartem.data.model.Genre

data class FilmItem(
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val year: Int,
    val description: String,
    val genres: List<Genre>,
    val countries: List<Country>
)
