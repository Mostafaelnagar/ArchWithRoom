package com.structure.base_mvvm.presentation.search.viewModels

import android.text.TextUtils
import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.structure.base_mvvm.domain.search.models.MovieResponse
import com.structure.base_mvvm.domain.search.use_case.SearchUseCase
import com.structure.base_mvvm.domain.utils.Resource
import com.structure.base_mvvm.presentation.BR
import com.structure.base_mvvm.presentation.base.BaseViewModel
import com.structure.base_mvvm.presentation.search.adapters.MoviesAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUseCase: SearchUseCase) :
  BaseViewModel() {
  val adapter: MoviesAdapter = MoviesAdapter()

  private val _homeResponse =
    MutableStateFlow<Resource<MovieResponse>>(Resource.Default)
  val homeResponse = _homeResponse

  @Bindable
  public var text: String = ""

  fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
    if (!TextUtils.isEmpty(s)) {
      searchForMovie(s.toString())
    }
  }

  fun click() {
    text = "1"
    notifyPropertyChanged(BR.text)
    Log.e("click", "click: " + text)
  }

  fun searchForMovie(movie_name: String) {
    searchUseCase.searchForMovie(movie_name)
      .onEach { result ->
        _homeResponse.value = result
      }
      .launchIn(viewModelScope)
  }

  var homePaginateData: MovieResponse = MovieResponse()
    set(value) {
      adapter.differ.submitList(value.movieData)
      field = value
    }
}