package com.structure.base_mvvm.domain.search.use_case

import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.search.repository.SearchRepository
import com.structure.base_mvvm.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class SearchUseCase @Inject constructor(
  private val searchRepository: SearchRepository
) {

  fun searchForMovie(movie_name: String): Flow<Resource<MovieResponse>> =
    flow {
      emit(Resource.Loading)
      val result = searchRepository.search(movie_name)
      emit(result)
    }.flowOn(Dispatchers.IO)
}