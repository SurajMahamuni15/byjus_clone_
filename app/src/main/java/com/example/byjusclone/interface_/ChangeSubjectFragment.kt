package com.example.byjusclone.interface_

import com.example.byjusclone.model.ChapterModel
import com.example.byjusclone.model.LessonModel

interface ChangeSubjectFragment {
    fun change(chapters: ArrayList<ChapterModel>, subjectName: String)
}

interface ChangeChapterFragment {
    fun change(chapters: ArrayList<LessonModel>, chapterTitle: String)
}

interface ChangeLessonFragment {
    fun change(lesson: ArrayList<LessonModel>,position : Int)
}
