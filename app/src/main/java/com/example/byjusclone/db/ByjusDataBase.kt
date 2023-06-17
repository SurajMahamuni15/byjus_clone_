package com.example.byjusclone.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.byjusclone.dao.BookmarkDao
import com.example.byjusclone.model.LessonModel

@Database(entities = [LessonModel::class], version = 1,exportSchema = false )
abstract class ByjusDataBase : RoomDatabase() {
    abstract fun getBookmarkDao() : BookmarkDao
}