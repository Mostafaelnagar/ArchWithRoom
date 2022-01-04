package com.structure.base_mvvm.presentation.movieDetails.viewModels

import androidx.lifecycle.viewModelScope
import com.structure.base_mvvm.domain.movieDetails.use_case.MovieDetailsUseCase
import com.structure.base_mvvm.domain.search.models.MovieData
import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.utils.Resource
import com.structure.base_mvvm.presentation.base.BaseViewModel
import com.structure.base_mvvm.presentation.base.utils.BaseUtils
import com.structure.base_mvvm.presentation.base.utils.SingleLiveEvent
import com.structure.base_mvvm.presentation.movieDetails.adapters.MovieVideosAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val movieDetailsUseCase: MovieDetailsUseCase) :
  BaseViewModel() {
  val adapter: MovieVideosAdapter = MovieVideosAdapter()
  val openPosterImageFullEvent = SingleLiveEvent<Int>()
  var movieData = MovieData()
    set(value) {
      movieData.id = value.id
      movieData.title = value.title
      movieData.posterPath = value.posterPath
      movieData.overview = value.overview
      field = value
    }
  private val _videosResponse =
    MutableStateFlow<Resource<MovieResponse>>(Resource.Default)
  val videoResponse = _videosResponse

  fun openFullImage() {
    openPosterImageFullEvent.value = BaseUtils.MOVIE_POSTER_FULL;
  }

  fun getVideosMovie() {
    movieDetailsUseCase.movieVideos(movieData.id)
      .onEach { result ->
        _videosResponse.value = result
      }
      .launchIn(viewModelScope)
  }

  var videoResult: MovieResponse = MovieResponse()
    set(value) {
      adapter.differ.submitList(value.movieData)
      field = value
    }
}