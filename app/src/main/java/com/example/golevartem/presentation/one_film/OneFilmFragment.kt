package com.example.golevartem.presentation.one_film

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.golevartem.R
import com.example.golevartem.data.FilmItem
import com.example.golevartem.databinding.FragmentFilmsBinding
import com.example.golevartem.databinding.FragmentOneFilmBinding
import com.example.golevartem.presentation.films.FilmsViewModel


class OneFilmFragment : Fragment() {

    lateinit var binding: FragmentOneFilmBinding
    lateinit var oneFilmViewModel: OneFilmViewModel
    lateinit var filmItem: FilmItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        oneFilmViewModel = ViewModelProvider(requireActivity()).get(OneFilmViewModel::class.java)
        binding = FragmentOneFilmBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oneFilmViewModel.requestOneFilm()


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()

        oneFilmViewModel.itemFilm.observe(activity as LifecycleOwner, Observer {
            filmItem = it

            with(binding){
                imageViewFullPoster.load("${filmItem.posterUrl}")
                textViewName.text = filmItem.nameRu
                textViewDescription.text = filmItem.description
                textViewGenre.text = filmItem.genres[0].toString()
                textViewCountry.text = filmItem.countries[0].toString()

            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    companion object {
        fun newInstance() = OneFilmFragment()
    }
}