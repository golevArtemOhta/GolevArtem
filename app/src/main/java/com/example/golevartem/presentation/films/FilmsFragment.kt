package com.example.golevartem.presentation.films

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
import com.example.golevartem.R
import com.example.golevartem.data.FilmItem
import com.example.golevartem.databinding.FragmentFilmsBinding


class FilmsFragment : Fragment() {
    lateinit var binding: FragmentFilmsBinding
    lateinit var filmsViewModel: FilmsViewModel
    lateinit var filmsItems: List<FilmItem>
    private val adapter = FilmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        filmsViewModel = ViewModelProvider(requireActivity()).get(FilmsViewModel::class.java)
        binding = FragmentFilmsBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        filmsViewModel.request()

        filmsViewModel.itemsFilms.observe(activity as LifecycleOwner, Observer {
            filmsItems = it
            adapter.setFilms(filmsItems)
            adapter.notifyDataSetChanged()
        })

        binding.rvFilms.layoutManager = LinearLayoutManager(context)
        binding.rvFilms.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = FilmsFragment()
    }
}