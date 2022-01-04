package com.structure.base_mvvm.presentation.search

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.structure.base_mvvm.domain.utils.Resource
import com.structure.base_mvvm.presentation.R
import com.structure.base_mvvm.presentation.base.BaseFragment
import com.structure.base_mvvm.presentation.base.extensions.*
import com.structure.base_mvvm.presentation.databinding.FragmentSearchBinding
import com.structure.base_mvvm.presentation.search.viewModels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

  private val viewModel: SearchViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_search

  override
  fun setBindingVariables() {
    binding.viewModel = viewModel
  }


  override
  fun setupObservers() {
    lifecycleScope.launchWhenResumed {
      viewModel.homeResponse.collect {
        when (it) {
          Resource.Loading -> {
            binding.progress.goneUnless(true)
          }
          is Resource.Success -> {
            viewModel.homePaginateData = it.value
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
    viewModel.adapter.singleEvent.observe(this) {

      val action = SearchFragmentDirections.actionHomeFragmentToMovieDetailsFragment(
        it.id,
        it.title,
        it.posterPath,
        it.overview
      )
      navigateSafe(action)
    }
  }

}