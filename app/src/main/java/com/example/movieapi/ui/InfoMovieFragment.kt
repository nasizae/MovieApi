package com.example.movieapi.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movieapi.R
import com.example.movieapi.databinding.FragmentInfoMovieBinding
import com.example.movieapi.databinding.FragmentSearchMovieBinding
import com.example.movieapi.model.MovieModel
import com.example.movieapi.presenter.InfoMoviePresenter
import com.example.movieapi.presenter.SearchMoviePresenter
import com.example.movieapi.view.InfoMovieView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InfoMovieFragment : Fragment(),InfoMovieView {
    private lateinit var binding:FragmentInfoMovieBinding
    @Inject
    lateinit var presenter: InfoMoviePresenter
    private lateinit var text:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentInfoMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.atachView(this)
        text  =arguments?.getString("key").toString()
        presenter.getMovieDetails(text)
    }

    override fun showInfoMovie(movieModel: MovieModel){
        with(binding){
            title.text=movieModel.Title
            year.text=movieModel.Year
            genre.text=movieModel.Genre
            awards.text=movieModel.Awards
            Glide.with(imgPoster).load(movieModel.Poster).into(imgPoster)
        }
    }

    override fun showInfoError(massage: String) {
        Toast.makeText(requireContext(), massage, Toast.LENGTH_SHORT).show()
    }
}