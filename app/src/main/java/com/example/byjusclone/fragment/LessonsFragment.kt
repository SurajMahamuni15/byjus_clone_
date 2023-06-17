package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.Constance.CHAPTERS
import com.example.byjusclone.Constance.CHAPTER_TITLE
import com.example.byjusclone.Constance.LESSON
import com.example.byjusclone.Constance.POSITION
import com.example.byjusclone.R
import com.example.byjusclone.adapter.LessonsAdapter
import com.example.byjusclone.databinding.FragmentLessonsBinding
import com.example.byjusclone.interface_.ChangeLessonFragment
import com.example.byjusclone.model.LessonModel
import com.example.byjusclone.utils.log
import com.example.byjusclone.utils.toastMessage
import com.example.byjusclone.viewModel.LessonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LessonsFragment : Fragment() {
    private var _binding: FragmentLessonsBinding? = null
    private val binding get() = _binding!!
    private var lessonList = ArrayList<LessonModel>()
    private val lessonViewModel by viewModels<LessonViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLessonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lessonList = arguments?.getParcelableArrayList(CHAPTERS)!!
        binding.secondContainer.title = arguments?.getString(CHAPTER_TITLE)!!
        initializeListener()
        initializeAdapter()
    }

    private fun initializeListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initializeAdapter() {
        val callback = object : ChangeLessonFragment {
            override fun change(lesson: ArrayList<LessonModel>, position: Int) {
                findNavController().navigate(
                    R.id.action_lessonsFragment_to_videoFragment,
                    Bundle().apply {
                        putParcelableArrayList(LESSON, lesson)
                        putInt(POSITION, position)
                    }
                )
            }

        }
        val adapter = LessonsAdapter(callback, ::addBookmark)
        adapter.setData(lessonList)
        binding.chaptersRv.adapter = adapter
    }


    private fun addBookmark(lessonModel: LessonModel) {
        lessonViewModel.addBookmarkVideo(lessonModel)
        toastMessage("{${lessonModel.title}} Added!")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}