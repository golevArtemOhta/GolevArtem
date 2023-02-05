package com.example.golevartem.presentation.one_film

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.golevartem.data.FilmItem
import com.example.golevartem.data.FilmRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FilmDetailsViewModel : ViewModel() {

    val itemFilm = MutableLiveData<FilmItem>()
    val message = MutableLiveData<String>()
    private val repository = FilmRepositoryImpl

    private var job: Job? = null

    fun requestOneFilm(id: Int) {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            try {
                val film = repository.getFilm(id)
                itemFilm.postValue(film)
            } catch (e: Throwable){
                Log.e("exeption", e.toString())
            }
        }

    }
}