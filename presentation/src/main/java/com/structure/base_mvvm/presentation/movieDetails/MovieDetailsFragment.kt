package com.structure.base_mvvm.presentation.movieDetails

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.navArgs
import com.structure.base_mvvm.domain.search.models.MovieData
import com.structure.base_mvvm.domain.utils.Resource
import com.structure.base_mvvm.presentation.base.BaseFragment
import com.structure.base_mvvm.presentation.base.extensions.*
import com.structure.base_mvvm.presentation.databinding.FragmentMovieDetailsBinding
import com.structure.base_mvvm.presentation.movieDetails.viewModels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

import com.structure.base_mvvm.presentation.R


@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {

  private val viewModel: MovieDetailsViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_movie_details

  override
  fun setBindingVariables() {
    binding.viewModel = viewModel
    val args: MovieDetailsFragmentArgs by navArgs()
    viewModel.movieData = MovieData(
      id = args.movieId,
      title = args.movieTitle,
      posterPath = args.moviePoster,
      overview = args.movieOverview
    )
    viewModel.getVideosMovie()
  }

  override
  fun setupObservers() {
    viewModel.openPosterImageFullEvent.observe(this) {
      val extras = FragmentNavigatorExtras(binding.icPoster to "movie_poster_full")
      val action =
        MovieDetailsFragmentDirections.actionMovieDetailsFragmentToMovieFullImageFragment()
      navigateSafeTransition(
        action.actionId,
        bundle = bundleOf("poster_image" to viewModel.movieData.posterPath),
        extras = extras
      )
    }
    lifecycleScope.launchWhenResumed {
      viewModel.videoResponse.collect {
        when (it) {
          Resource.Loading -> {
            binding.progress.goneUnless(true)
          }
          is Resource.Success -> {
            viewModel.videoResult = it.value
            binding.progress.goneUnless(false)
          }
          is Resource.Failure -> {
            hideKeyboard()
            binding.progress.goneUnless(false)
            handleApiError(it)
          }
        }
      }
    }
  }

}