package com.example.golevartem.presentation.one_film

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.golevartem.data.model.FilmItem
import com.example.golevartem.databinding.FragmentOneFilmBinding


class FilmDetailsFragment() : Fragment() {

    lateinit var binding: FragmentOneFilmBinding
    lateinit var oneFilmViewModel: FilmDetailsViewModel
    lateinit var filmItem: FilmItem
    private var myCondition = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        oneFilmViewModel =
            ViewModelProvider(requireActivity()).get(FilmDetailsViewModel::class.java)
        binding = FragmentOneFilmBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        val bundle = this.arguments
        val filmInfo = bundle?.getParcelable<FilmItem>("film")


        with(binding) {
            imageViewFullPoster.load("${filmInfo?.posterUrl}")
            textViewName.text = filmInfo?.nameRu
            textViewDescription.text = filmInfo?.description

            val genries = filmInfo?.genres
            var indexGenries = 0
            var textGenries = ""
            if (textGenries != null) {
                if (genries != null) {
                    for (item in genries) {
                        if (indexGenries == (genries.size - 1)) {
                            textGenries +=
                                "${item.genre}"
                        } else {
                            textGenries +=
                                "${item.genre}, "
                        }
                        indexGenries++
                    }
                }
            }


            val countries = filmInfo?.countries
            var indexCountries = 0
            var textCountries = ""
            if (textCountries != null) {
                if (countries != null) {
                    for (item in countries) {
                        if (indexCountries == (countries.size - 1)) {
                            textCountries +=
                                "${item.country}"
                        } else {
                            textCountries +=
                                "${item.country}, "
                        }
                        indexCountries++
                    }
                }
            }

            textViewGenre.text = textGenries
            textViewCountry.text = textCountries
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            getActivity()?.onBackPressed();
        }
    }


    companion object {
        fun newInstance() = FilmDetailsFragment()
    }

}