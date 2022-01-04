package com.structure.base_mvvm.data.local.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleLocalDataSource {
//  @Query("SELECT * FROM note")
//  fun getNotes(): Flow<List<Note>>
//@Insert(onConflict = OnConflictStrategy.REPLACE)
//suspend fun insertNote(note: Note)

}