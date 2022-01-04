package com.structure.base_mvvm.data.local.data_source

import androidx.room.RoomDatabase

abstract class ArticleDatabase : RoomDatabase() {
  abstract val articleLocalDataSource: ArticleLocalDataSource

  companion object {
    const val DATABASE_NAME = "article.db"
  }
}