package com.example.golevartem.data

import android.util.Log
import com.example.golevartem.data.network.RetrofitFactory
import com.example.golevartem.domain.FilmRepository
import java.util.concurrent.ConcurrentHashMap

object FilmRepositoryImpl: FilmRepository {

    private val api = RetrofitFactory.getFilmsApiService()
    private val memoryCache = ConcurrentHashMap<String, Any>()

    override suspend fun getFilms(page: Int): List<FilmItem> {
        Log.d("getFilms", "$page")

        val filmsFromCache = memoryCache.get("page$page") as? FilmsTop?

        val films = if (filmsFromCache != null){
            filmsFromCache
        }
        else{
            val filmsFromNetwork = api.getFilms("TOP_100_POPULAR_FILMS", page)
            memoryCache["page$page"] = filmsFromNetwork
            filmsFromNetwork
        }
        return films.films
    }

    override suspend fun getOneFilm(): FilmItem{
        val film = api.getOneFilm(451)
        return film
    }




}