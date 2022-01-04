package com.structure.base_mvvm.domain.movieDetails.use_case

import com.structure.base_mvvm.domain.movieDetails.repository.MovieRepository
import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(
  private val movieRepository: MovieRepository
) {

  fun movieVideos(movieId: String): Flow<Resource<MovieResponse>> =
    flow {
      emit(Resource.Loading)
      val result = movieRepository.getMovieVideos(movieId)
      emit(result)
    }.flowOn(Dispatchers.IO)
}