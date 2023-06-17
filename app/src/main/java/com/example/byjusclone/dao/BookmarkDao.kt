package com.example.byjusclone.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.byjusclone.model.LessonModel
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBookmarkVideo(lessonModel: LessonModel)

    @Query("select * from lessonVideo")
    fun getAllBookmarkVideos(): Flow<List<LessonModel>>

}
