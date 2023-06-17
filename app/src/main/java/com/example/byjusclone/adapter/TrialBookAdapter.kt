package com.example.byjusclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.byjusclone.databinding.FreeTrialBookItemBinding
import com.example.byjusclone.viewHolder.TrialBookViewHolder

class TrialBookAdapter : Adapter<TrialBookViewHolder>() {
    private var data = ArrayList<String>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrialBookViewHolder {
            val binding =
                FreeTrialBookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TrialBookViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return 5
        }

        override fun onBindViewHolder(holder: TrialBookViewHolder, position: Int) {

        }

        fun setData(newData: ArrayList<String>) {
            val trialBookDiffUtil = TrialBookDiffUtil(data, newData)
            val trialBookDiff = DiffUtil.calculateDiff(trialBookDiffUtil)
            data = newData
            trialBookDiff.dispatchUpdatesTo(this)

        }

        class TrialBookDiffUtil(private val oldData: ArrayList<String>, private val newData: ArrayList<String>) :
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