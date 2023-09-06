package com.example.movieapi.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapi.R
import com.example.movieapi.databinding.FragmentSearchMovieBinding
import com.example.movieapi.model.MovieModel
import com.example.movieapi.presenter.SearchMoviePresenter
import com.example.movieapi.view.SearchMovieView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchMovieFragment : Fragment() ,SearchMovieView{
      @Inject
    lateinit var presenter: SearchMoviePresenter
        private lateinit var binding: FragmentSearchMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentSearchMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.atachView(this)
        initClicker()
    }

    override fun initClicker() {
        binding.btnSearch.setOnClickListener {
            val text = binding.etSearch.text.toString()
            findNavController().navigate(R.id.infoMovieFragment, bundleOf("key" to text))
        }
    }

}