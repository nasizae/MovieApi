package com.example.movieapi.view

import com.example.movieapi.model.MovieModel

interface InfoMovieView {

    fun showInfoMovie(movieModel: MovieModel)

    fun showInfoError(massage:String)
}