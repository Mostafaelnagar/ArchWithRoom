package com.structure.base_mvvm.data.movieDetails.data_source.remote

import com.structure.base_mvvm.domain.search.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsServices {
  @GET("movie/{movieId}/videos?api_key=36162c1a2c0d426a0089ee06883f5035")
  suspend fun movieVideos(
    @Path("movieId") movieId: String
  ): MovieResponse
}