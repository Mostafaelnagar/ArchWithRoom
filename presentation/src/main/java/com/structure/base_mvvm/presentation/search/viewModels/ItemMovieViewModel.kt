package com.structure.base_mvvm.presentation.search.viewModels

import com.structure.base_mvvm.domain.search.models.MovieData
import com.structure.base_mvvm.presentation.base.BaseViewModel
import com.structure.base_mvvm.presentation.base.utils.BaseUtils

class ItemMovieViewModel constructor(val homeData: MovieData) : BaseViewModel() {
  fun action() {
    singleEvent.value = BaseUtils.MOVIE_DETAILS
  }
}