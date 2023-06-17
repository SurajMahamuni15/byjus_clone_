package com.example.byjusclone.model

import android.os.Parcel
import android.os.Parcelable

data class ChapterModel(val chapterTitle: String, val count: Int,val lessons : ArrayList<LessonModel>) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        TODO("lessons")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(chapterTitle)
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChapterModel> {
        override fun createFromParcel(parcel: Parcel): ChapterModel {
            return ChapterModel(parcel)
        }

        override fun newArray(size: Int): Array<ChapterModel?> {
            return arrayOfNulls(size)
        }
    }
}