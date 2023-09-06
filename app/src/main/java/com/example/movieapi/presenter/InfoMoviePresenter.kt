package com.example.movieapi.presenter

import com.example.movieapi.MovieApi
import com.example.movieapi.model.MovieModel
import com.example.movieapi.view.InfoMovieView
import com.example.movieapi.view.SearchMovieView
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class InfoMoviePresenter @Inject constructor(private val movieApi: MovieApi){
    lateinit var movieView: InfoMovieView

    fun getMovieDetails(name:String){
        movieApi.getMovie(name).enqueue(object :
            retrofit2.Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                response.body()?.let {
                    movieView.showInfoMovie(it)
                }
            }
            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                movieView.showInfoError(t.message.toString())
            }
        })
    }

    fun atachView(view: InfoMovieView){
        this.movieView=view
    }
}