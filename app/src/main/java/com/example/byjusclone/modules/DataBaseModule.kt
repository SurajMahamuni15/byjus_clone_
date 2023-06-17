package com.example.byjusclone.modules

import android.content.Context
import androidx.room.Room
import com.example.byjusclone.dao.BookmarkDao
import com.example.byjusclone.db.ByjusDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun getBookmarkDao(byjusDataBase: ByjusDataBase): BookmarkDao {
        return byjusDataBase.getBookmarkDao()
    }

    @Provides
    @Singleton
    fun getLessonsDataBase(@ApplicationContext context: Context): ByjusDataBase {
        return Room.databaseBuilder(context, ByjusDataBase::class.java, "BookmarkVideos").build()
    }
}