package com.example.byjusclone.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.byjusclone.R
import com.example.byjusclone.databinding.VideoPlaylistItemBinding
import com.example.byjusclone.interface_.ChangeLessonFragment
import com.example.byjusclone.model.LessonModel
import com.example.byjusclone.viewHolder.VideoPlayListViewHolder

class VideoPlayListAdapter(val callback: ChangeLessonFragment) :
    RecyclerView.Adapter<VideoPlayListViewHolder>() {
    private lateinit var context: Context
    var selected_postion = -1
    private var data = ArrayList<LessonModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoPlayListViewHolder {
        context = parent.context
        val binding =
            VideoPlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoPlayListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VideoPlayListViewHolder, position: Int) {
        holder.binding.videoTitle.text = data[position].title
        Glide.with(context).load(data[position].thumb).into(holder.binding.videoThumb)
        holder.binding.videoPlayListItemContainer.setOnClickListener {
            callback.change(data, position)
            selected_postion = position
            notifyDataSetChanged()
            Log.e("selection", position.toString())
        }
        if (selected_postion == position) {
            holder.binding.container.setBackgroundColor(context.getColor(R.color.selected_color))
            holder.binding.playing.text = context.getString(R.string.now_playing)
        } else {
            holder.binding.container.setBackgroundColor(Color.TRANSPARENT)
            holder.binding.playing.text = ""
        }
    }

    fun setData(newData: ArrayList<LessonModel>, videoPosition: Int) {
        selected_postion = videoPosition
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

//    inner class VideoPlayListViewHolder(val binding: VideoPlaylistItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.videoPlayListItemContainer.setOnClickListener {
//                setSingleSelection(
//                    adapterPosition
//                )
//            }
//        }
//
//
//    }

//    private fun setSingleSelection(adapterPosition: Int) {
//        if (adapterPosition == RecyclerView.NO_POSITION) return
//        notifyItemChanged(selected_postion)
//        selected_postion = adapterPosition
//        notifyItemChanged(selected_postion)
//
//    }
}