package com.structure.base_mvvm.domain.search.repository
import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.utils.Resource

interface SearchRepository {
  suspend fun search( movie_name: String): Resource<MovieResponse>
}