package com.example.golevartem.presentation.films

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.golevartem.R
import com.example.golevartem.data.FilmItem
import com.example.golevartem.databinding.FilmItemBinding
import com.example.golevartem.presentation.one_film.OneFilmFragment

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmsHolder>() {
    val filmsList = ArrayList<FilmItem>()

    class FilmsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = FilmItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(film: FilmItem) = with(binding) {

            poster.load("${film.posterUrlPreview}")
            textViewName.text = film.nameRu
            val filmsGenries = film.genres
            var genreOfFilmsToString = ""
            var index = 0

            for (item in filmsGenries) {
                if (index == (filmsGenries.size-1)){
                    genreOfFilmsToString +=
                        "${item.genre}"
                } else{
                    genreOfFilmsToString +=
                        "${item.genre}, "
                }
                index++
            }

            textViewGenreAndYear.text = "$genreOfFilmsToString (${film.year})"

            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {

                    val activity = p0?.getContext() as AppCompatActivity
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, OneFilmFragment.newInstance()).addToBackStack(null)
                        .commit()

                }
            })

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
        //filmsList.clear()
        filmsList.addAll(films)
    }

}