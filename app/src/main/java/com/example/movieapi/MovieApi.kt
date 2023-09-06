package com.example.movieapi

import com.example.movieapi.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(".")
    fun getMovie(
        @Query("t") name: String,
        @Query("apikey") key: String = "ef2a0f67"
    ):Call<MovieModel>

}