package com.example.movieapi.model

import java.io.Serializable

data class MovieModel(
    var Title: String,
    var Year: String,
    var Genre: String,
    var Awards: String,
    var Poster: String,
    var Ratings: ArrayList<RatingModel>,
):Serializable