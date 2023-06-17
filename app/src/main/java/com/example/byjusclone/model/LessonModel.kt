package com.example.byjusclone.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lessonVideo")
data class LessonModel(@PrimaryKey @ColumnInfo(name = "videoHistoryID") val videoID: String,val thumb: String, val title: String, val videoUrl: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(videoID)
        parcel.writeString(thumb)
        parcel.writeString(title)
        parcel.writeString(videoUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LessonModel> {
        override fun createFromParcel(parcel: Parcel): LessonModel {
            return LessonModel(parcel)
        }

        override fun newArray(size: Int): Array<LessonModel?> {
            return arrayOfNulls(size)
        }
    }
}