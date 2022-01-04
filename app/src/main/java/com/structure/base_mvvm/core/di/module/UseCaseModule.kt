package com.structure.base_mvvm.core.di.module

import com.structure.base_mvvm.domain.movieDetails.repository.MovieRepository
import com.structure.base_mvvm.domain.movieDetails.use_case.MovieDetailsUseCase
import com.structure.base_mvvm.domain.search.repository.SearchRepository
import com.structure.base_mvvm.domain.search.use_case.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

  @Provides
  @Singleton
  fun provideSearchUseCase(
    searchRepository: SearchRepository
  ): SearchUseCase = SearchUseCase(searchRepository)

  @Provides
  @Singleton
  fun provideMovieDetailsUseCase(
    movieRepository: MovieRepository
  ): MovieDetailsUseCase = MovieDetailsUseCase(movieRepository)

}