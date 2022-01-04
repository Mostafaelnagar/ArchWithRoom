package com.structure.base_mvvm.presentation.movieDetails.viewModels

import com.structure.base_mvvm.domain.search.models.MovieData
import com.structure.base_mvvm.presentation.base.BaseViewModel
import com.structure.base_mvvm.presentation.base.utils.BaseUtils

class ItemVideoViewModel constructor(val movieVideo: MovieData) : BaseViewModel() {
  fun action() {
    singleEvent.value = BaseUtils.MOVIE_DETAILS
  }
}