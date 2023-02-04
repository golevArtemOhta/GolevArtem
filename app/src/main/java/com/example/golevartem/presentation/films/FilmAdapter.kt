package com.example.golevartem.presentation.films

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.golevartem.R
import com.example.golevartem.data.FilmItem
import com.example.golevartem.databinding.FilmItemBinding

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmsHolder>() {
    val filmsList = ArrayList<FilmItem>()

    class FilmsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = FilmItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(film: FilmItem) = with(binding) {

            poster.load("${film.posterUrlPreview}")
            textViewName.text = film.nameRu
            val genreOfFilmsToString = film.genres.get(0)
            textViewGenreAndYear.text = "$genreOfFilmsToString (${film.year})"

            itemView.setOnClickListener {
                TODO()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item, parent, false)
        return FilmsHolder(view)
    }

    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        holder.bind(filmsList[position])
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    fun setFilms(films: List<FilmItem>) {
        filmsList.clear()
        filmsList.addAll(films)
    }

}