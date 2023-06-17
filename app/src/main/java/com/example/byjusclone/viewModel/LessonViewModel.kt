package com.example.byjusclone.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.byjusclone.Repository
import com.example.byjusclone.dao.BookmarkDao
import com.example.byjusclone.model.LessonModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonViewModel @Inject constructor(bookmarkDao: BookmarkDao) : ViewModel() {

    private var repository: Repository

    init {
        repository = Repository(bookmarkDao)
    }

    fun addBookmarkVideo(lessonModel: LessonModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBookmarkVideo(lessonModel)
        }
    }

    fun getAllBookmarkVideos(): LiveData<List<LessonModel>> {
        return repository.getAllBookmarkVideos().asLiveData(Dispatchers.Main)
    }

}