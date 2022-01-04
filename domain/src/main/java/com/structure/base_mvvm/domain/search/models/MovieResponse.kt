package com.structure.base_mvvm.domain.search.models

import com.google.gson.annotations.SerializedName

class MovieResponse(
  @SerializedName("page")
  val page: Int = 0,
  @SerializedName("results")
  val movieData: List<MovieData> = listOf(),
  @SerializedName("total_pages")
  val totalPages: Int = 0,
  @SerializedName("total_results")
  val totalResults: Int = 0
)