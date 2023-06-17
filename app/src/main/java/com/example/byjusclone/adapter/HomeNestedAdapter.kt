package com.example.byjusclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.byjusclone.interface_.ChangeSubjectFragment
import com.example.byjusclone.databinding.HomeNestedItemBinding
import com.example.byjusclone.model.SubjectModel
import com.example.byjusclone.viewHolder.HomeNestedViewHolder

class HomeNestedAdapter(val callback: ChangeSubjectFragment) : Adapter<HomeNestedViewHolder>() {
    private var subjectData = ArrayList<SubjectModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNestedViewHolder {
        val binding =
            HomeNestedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeNestedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subjectData.size
    }

    override fun onBindViewHolder(holder: HomeNestedViewHolder, position: Int) {
        holder.nestedBinding.subjectTitle.text = subjectData[position].subjectTitle
        holder.nestedBinding.subjectImg.setImageResource(subjectData[position].img)
        holder.nestedBinding.itemContainer.setOnClickListener {
            callback.change(subjectData[position].chapterModel, subjectData[position].subjectTitle)
        }

    }

    fun setNestedData(newData: ArrayList<SubjectModel>) {
        val homeNestedDiffUtil = HomeNestedDiffUtil(subjectData, newData)
        val homeNestedDiff = DiffUtil.calculateDiff(homeNestedDiffUtil)
        subjectData = newData
        homeNestedDiff.dispatchUpdatesTo(this)

    }

    class HomeNestedDiffUtil(
        private val oldData: ArrayList<SubjectModel>,
        private val newData: ArrayList<SubjectModel>
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