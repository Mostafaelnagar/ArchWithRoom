package com.structure.base_mvvm.presentation.movieDetails

import android.transition.TransitionInflater
import androidx.fragment.app.viewModels
import com.structure.base_mvvm.domain.search.models.MovieData
import com.structure.base_mvvm.presentation.base.BaseFragment
import com.structure.base_mvvm.presentation.movieDetails.viewModels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.structure.base_mvvm.presentation.R
import com.structure.base_mvvm.presentation.databinding.FragmentMovieFullImageBinding


@AndroidEntryPoint
class MovieFullImageFragment : BaseFragment<FragmentMovieFullImageBinding>() {

  private val viewModel: MovieDetailsViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_movie_full_image

  override
  fun setBindingVariables() {
    binding.viewModel = viewModel
    viewModel.movieData = MovieData(
      posterPath = requireArguments().getString("poster_image")
    )
    val animation =
      TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
    sharedElementEnterTransition = animation
    sharedElementReturnTransition = animation
  }
}