package com.example.movieapi.presenter

import com.example.movieapi.MovieApi
import com.example.movieapi.model.MovieModel
import com.example.movieapi.view.SearchMovieView
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback


class SearchMoviePresenter @Inject constructor(private val movieApi: MovieApi) {

    lateinit var movieView: SearchMovieView

    fun atachView(movieView: SearchMovieView){
        this.movieView = movieView
    }


}