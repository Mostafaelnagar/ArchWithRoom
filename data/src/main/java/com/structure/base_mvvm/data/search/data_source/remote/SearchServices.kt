package com.structure.base_mvvm.data.search.data_source.remote

import com.structure.base_mvvm.domain.search.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchServices {
  @GET("search/movie?api_key=36162c1a2c0d426a0089ee06883f5035&")
  suspend fun search(
    @Query("query") movie_name: String
  ): MovieResponse
}