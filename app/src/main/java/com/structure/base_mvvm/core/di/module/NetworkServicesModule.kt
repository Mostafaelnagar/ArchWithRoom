package com.structure.base_mvvm.core.di.module

import com.structure.base_mvvm.data.general.data_source.remote.GeneralServices
import com.structure.base_mvvm.data.movieDetails.data_source.remote.MovieDetailsServices
import com.structure.base_mvvm.data.search.data_source.remote.SearchServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

  @Provides
  @Singleton
  fun provideGeneralServices(retrofit: Retrofit): GeneralServices =
    retrofit.create(GeneralServices::class.java)

  @Provides
  @Singleton
  fun provideSearchServices(retrofit: Retrofit): SearchServices =
    retrofit.create(SearchServices::class.java)

  @Provides
  @Singleton
  fun provideMovieServices(retrofit: Retrofit): MovieDetailsServices =
    retrofit.create(MovieDetailsServices::class.java)

}