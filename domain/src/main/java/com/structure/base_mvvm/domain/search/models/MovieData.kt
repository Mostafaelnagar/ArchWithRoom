package com.structure.base_mvvm.domain.search.models


import com.google.gson.annotations.SerializedName

data class MovieData(
  @SerializedName("adult")
  val adult: Boolean = false,
  @SerializedName("backdrop_path")
  val backdropPath: String = "",
  @SerializedName("genre_ids")
  val genreIds: List<Int> = listOf(),
  @SerializedName("id")
  var id: String = "",
  @SerializedName("original_language")
  val originalLanguage: String = "",
  @SerializedName("original_title")
  var originalTitle: String = "",
  @SerializedName("overview")
  var overview: String = "",
  @SerializedName("popularity")
  val popularity: Double = 0.0,
  @SerializedName("poster_path")
  var posterPath: String? = "",
  @SerializedName("release_date")
  val releaseDate: String = "",
  @SerializedName("title")
  var title: String = "",
  @SerializedName("video")
  val video: Boolean = false,
  @SerializedName("vote_average")
  val voteAverage: Double = 0.0,
  @SerializedName("vote_count")
  val voteCount: Int = 0,
  @SerializedName("key")
  val key: String = ""
)