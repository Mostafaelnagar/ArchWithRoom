package com.structure.base_mvvm.domain.movieDetails.repository

import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.utils.Resource

interface MovieRepository {
  suspend fun getMovieVideos(movieId: String): Resource<MovieResponse>
}