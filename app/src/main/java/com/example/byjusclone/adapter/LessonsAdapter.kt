package com.example.byjusclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.byjusclone.databinding.LessonItemBinding
import com.example.byjusclone.interface_.ChangeLessonFragment
import com.example.byjusclone.model.LessonModel
import com.example.byjusclone.viewHolder.LessonViewHolder
import kotlin.reflect.KFunction1

class LessonsAdapter(
    val callback: ChangeLessonFragment,
    var addBookmark: (lesson: LessonModel) -> Unit
) : RecyclerView.Adapter<LessonViewHolder>() {
    private lateinit var context: Context
    private var data = ArrayList<LessonModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        context = parent.context
        val binding =
            LessonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.binding.videoTitle.text = data[position].title
        Glide.with(context).load(data[position].thumb).into(holder.binding.videoThumb)
        holder.binding.lessonItemContainer.setOnClickListener {
            callback.change(data, position)
        }
        holder.binding.bookmark.setOnClickListener {
            addBookmark(data[position])
        }
    }

    fun setData(newData: ArrayList<LessonModel>) {
        val lessonDiffUtil = LessonDiffUtil(data, newData)
        val lessonDiff = DiffUtil.calculateDiff(lessonDiffUtil)
        data = newData
        lessonDiff.dispatchUpdatesTo(this)

    }

    class LessonDiffUtil(
        private val oldData: ArrayList<LessonModel>,
        private val newData: ArrayList<LessonModel>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldData.size
        }

        override fun getNewListSize(): Int {
            return newData.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldData[oldItemPosition] == newData[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldData[oldItemPosition] == newData[newItemPosition]
        }

    }
}