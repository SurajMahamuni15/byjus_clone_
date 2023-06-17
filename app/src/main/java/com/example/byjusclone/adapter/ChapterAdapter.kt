package com.example.byjusclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.byjusclone.databinding.ChapterItemBinding
import com.example.byjusclone.interface_.ChangeChapterFragment
import com.example.byjusclone.model.ChapterModel
import com.example.byjusclone.viewHolder.ChapterViewHolder

class ChapterAdapter(val callback: ChangeChapterFragment) :
    RecyclerView.Adapter<ChapterViewHolder>() {
    private var data = ArrayList<ChapterModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val binding =
            ChapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.chapterBinding.chapterTitle.text = data[position].chapterTitle
        holder.chapterBinding.chapterCount.text = data[position].count.toString()
        holder.chapterBinding.chapterContainer.setOnClickListener {
            callback.change(data[position].lessons, data[position].chapterTitle)

        }

    }

    fun setData(newData: ArrayList<ChapterModel>) {
        val chapterDiffUtil = ChapterDiffUtil(data, newData)
        val chapterDiff = DiffUtil.calculateDiff(chapterDiffUtil)
        data = newData
        chapterDiff.dispatchUpdatesTo(this)

    }

    class ChapterDiffUtil(
        private val oldData: ArrayList<ChapterModel>,
        private val newData: ArrayList<ChapterModel>
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