package com.structure.base_mvvm.core.di.module

import com.structure.base_mvvm.data.general.data_source.remote.GeneralRemoteDataSource
import com.structure.base_mvvm.data.general.repository.GeneralRepositoryImpl
import com.structure.base_mvvm.data.movieDetails.data_source.remote.MovieDetailsRemoteDataSource
import com.structure.base_mvvm.data.movieDetails.repository.MovieDetailsRepositoryImpl
import com.structure.base_mvvm.data.local.preferences.AppPreferences
import com.structure.base_mvvm.data.search.data_source.remote.SearchRemoteDataSource
import com.structure.base_mvvm.data.search.repository.SearchRepositoryImpl
import com.structure.base_mvvm.domain.general.repository.GeneralRepository
import com.structure.base_mvvm.domain.movieDetails.repository.MovieRepository
import com.structure.base_mvvm.domain.search.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Provides
  @Singleton
  fun provideGeneralRepository(
    remoteDataSource: GeneralRemoteDataSource,
    appPreferences: AppPreferences
  ): GeneralRepository = GeneralRepositoryImpl(remoteDataSource, appPreferences)


  @Provides
  @Singleton
  fun provideSearchRepository(
    remoteDataSource: SearchRemoteDataSource
  ): SearchRepository = SearchRepositoryImpl(remoteDataSource)

  @Provides
  @Singleton
  fun provideMovieDetailsRepository(
    remoteDataSource: MovieDetailsRemoteDataSource
  ): MovieRepository = MovieDetailsRepositoryImpl(remoteDataSource)

}