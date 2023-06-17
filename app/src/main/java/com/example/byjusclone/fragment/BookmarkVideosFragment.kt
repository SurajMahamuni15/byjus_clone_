package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.R
import com.example.byjusclone.adapter.VideoPlayListAdapter
import com.example.byjusclone.databinding.FragmentBookmarkVideosBinding
import com.example.byjusclone.interface_.ChangeLessonFragment
import com.example.byjusclone.model.LessonModel
import com.example.byjusclone.viewModel.LessonViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkVideosFragment : Fragment() {
    private var _binding: FragmentBookmarkVideosBinding? = null
    private val binding get() = _binding!!
    private val lessonViewModel by viewModels<LessonViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListener()
        initializeAdapter()
    }

    private fun initializeAdapter() {
        val callback = object : ChangeLessonFragment {
            override fun change(lesson: ArrayList<LessonModel>, position: Int) {

            }
        }
        val adapter = VideoPlayListAdapter(callback)
        lessonViewModel.getAllBookmarkVideos().observe(viewLifecycleOwner){
            adapter.setData(it as ArrayList<LessonModel>,-1)
        }
        binding.videosRv.adapter = adapter
    }

    private fun initializeListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }


}