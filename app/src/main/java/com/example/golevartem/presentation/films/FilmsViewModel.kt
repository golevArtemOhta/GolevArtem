package com.example.golevartem.presentation.films

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.golevartem.data.model.FilmItem
import com.example.golevartem.data.FilmRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class FilmsViewModel : ViewModel() {

    val itemsFilms = MutableLiveData<List<FilmItem>>()
    val message = MutableLiveData<String>()
    private val repository = FilmRepositoryImpl
    private var page = 1
    private var isAllFilmsLoaded = false
    private var isLoading = false

    private var job: Job? = null

    fun request() {
        if (isAllFilmsLoaded || isLoading) {
            return
        }
        isLoading = true
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            try {
                val films = repository.getFilms(page)
                if (films.isEmpty()) {
                    message.value = "These are all popular movies"
                } else {
                    if (films.size < 20) isAllFilmsLoaded = true
                    itemsFilms.postValue(films)
                }
                page++
            } catch (e: Throwable) {
                Log.e("exeption", e.toString())
            }


            isLoading = false
        }

    }
}