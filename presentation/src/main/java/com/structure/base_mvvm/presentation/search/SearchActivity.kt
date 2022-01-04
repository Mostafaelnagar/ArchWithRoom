package com.structure.base_mvvm.presentation.search

import com.structure.base_mvvm.presentation.R
import com.structure.base_mvvm.presentation.base.BaseActivity
import com.structure.base_mvvm.presentation.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : BaseActivity<ActivityMovieBinding>() {

  override
  fun getLayoutId() = R.layout.activity_movie

}