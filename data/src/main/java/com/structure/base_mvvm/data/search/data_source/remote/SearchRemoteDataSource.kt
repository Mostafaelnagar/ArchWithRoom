package com.structure.base_mvvm.data.search.data_source.remote

import com.structure.base_mvvm.data.remote.BaseRemoteDataSource
import javax.inject.Inject

class SearchRemoteDataSource @Inject constructor(private val apiService: SearchServices) :
  BaseRemoteDataSource() {

  suspend fun search( movie_name: String) = safeApiCall {
    apiService.search( movie_name)
  }
}