package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.byjusclone.R
import com.example.byjusclone.adapter.TrialBookAdapter
import com.example.byjusclone.databinding.FragmentOnlineClassBinding

class OnlineClassFragment : Fragment() {
    private var _binding: FragmentOnlineClassBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnlineClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeAdapter()
    }

    private fun initializeAdapter() {
        val adapter = TrialBookAdapter()
        binding.booksRv.adapter = adapter
    }

}