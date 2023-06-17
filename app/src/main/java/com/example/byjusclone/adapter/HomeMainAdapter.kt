package com.example.byjusclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.byjusclone.interface_.ChangeSubjectFragment
import com.example.byjusclone.databinding.HomeMainItemBinding
import com.example.byjusclone.model.HomeMainModel
import com.example.byjusclone.viewHolder.HomeMainViewHolder

class HomeMainAdapter(val callback: ChangeSubjectFragment) : Adapter<HomeMainViewHolder>() {
    private var modelData = ArrayList<HomeMainModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMainViewHolder {
        val binding =
            HomeMainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeMainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modelData.size
    }

    override fun onBindViewHolder(holder: HomeMainViewHolder, position: Int) {
        holder.mainBinding.title.text = modelData[position].title
        val adapter = HomeNestedAdapter(callback)
        adapter.setNestedData(modelData[position].subject)
        holder.mainBinding.nestedRv.adapter = adapter

    }


    fun setData(newData: ArrayList<HomeMainModel>) {
        val homeMainDiffUtil = HomeMainDiffUtil(modelData, newData)
        val homeDiff = DiffUtil.calculateDiff(homeMainDiffUtil)
        modelData = newData
        homeDiff.dispatchUpdatesTo(this)

    }

    class HomeMainDiffUtil(
        private val oldData: ArrayList<HomeMainModel>,
        private val newData: ArrayList<HomeMainModel>
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