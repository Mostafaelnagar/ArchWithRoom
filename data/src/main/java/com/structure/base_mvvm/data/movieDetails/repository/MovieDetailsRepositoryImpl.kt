package com.structure.base_mvvm.data.movieDetails.repository

import com.structure.base_mvvm.data.movieDetails.data_source.remote.MovieDetailsRemoteDataSource
import com.structure.base_mvvm.domain.movieDetails.repository.MovieRepository
import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.utils.Resource
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(private val remoteDataSource: MovieDetailsRemoteDataSource) :
  MovieRepository {
  override suspend fun getMovieVideos(movieId: String): Resource<MovieResponse> =
    remoteDataSource.getMovieVideos(movieId)

}