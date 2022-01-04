package com.structure.base_mvvm.data.movieDetails.data_source.remote

import com.structure.base_mvvm.data.remote.BaseRemoteDataSource
import javax.inject.Inject

class MovieDetailsRemoteDataSource @Inject constructor(private val apiService: MovieDetailsServices) :
  BaseRemoteDataSource() {

  suspend fun getMovieVideos(movieId: String) = safeApiCall {
    apiService.movieVideos(movieId)
  }
}