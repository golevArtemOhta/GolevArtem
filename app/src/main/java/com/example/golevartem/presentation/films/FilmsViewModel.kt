package com.example.golevartem.presentation.films

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.golevartem.data.FilmItem
import com.example.golevartem.data.FilmRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FilmsViewModel : ViewModel() {

    val itemsFilms = MutableLiveData<List<FilmItem>>()
    private val repository = FilmRepositoryImpl

    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val films = repository.getFilms()
            itemsFilms.postValue(films)
        }
    }
}