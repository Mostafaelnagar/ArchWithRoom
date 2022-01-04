package com.structure.base_mvvm.data.search.repository

import com.structure.base_mvvm.data.search.data_source.remote.SearchRemoteDataSource
import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.search.repository.SearchRepository
import com.structure.base_mvvm.domain.utils.Resource
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val remoteDataSource: SearchRemoteDataSource) :
  SearchRepository {
  override suspend fun search(movie_name: String): Resource<MovieResponse> =
    remoteDataSource.search(movie_name)
}