package com.example.byjusclone

import com.example.byjusclone.dao.BookmarkDao
import com.example.byjusclone.model.LessonModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val bookmarkDao: BookmarkDao) {

    fun addBookmarkVideo(lessonModel: LessonModel) {
        bookmarkDao.addBookmarkVideo(lessonModel)
    }

    fun getAllBookmarkVideos(): Flow<List<LessonModel>> {
        return bookmarkDao.getAllBookmarkVideos()
    }
}