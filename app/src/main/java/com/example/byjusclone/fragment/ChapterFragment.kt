package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.R
import com.example.byjusclone.adapter.ChapterAdapter
import com.example.byjusclone.databinding.FragmentChapterBinding
import com.example.byjusclone.interface_.ChangeChapterFragment
import com.example.byjusclone.model.ChapterModel
import com.example.byjusclone.model.LessonModel
import com.example.byjusclone.utils.log


class ChapterFragment : Fragment() {
    private var _binding: FragmentChapterBinding? = null
    private val binding get() = _binding!!
    private var chapterList = ArrayList<ChapterModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChapterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chapterList = arguments?.getParcelableArrayList("chapterList")!!
        binding.secondContainer.title = arguments?.getString("subject")!!
        binding.chapterCount.text =
            getString(R.string.total_chapter_count, chapterList.size.toString())
        initializeMenu()
        initializeListener()
        initializeAdapter()
    }

    private fun initializeMenu() {
        binding.toolbar.setOnMenuItemClickListener { it ->
            when (it.itemId) {
                R.id.bookmark -> {
                    findNavController().navigate(R.id.action_chapterFragment_to_bookmarkVideosFragment)
                }

                else -> {
                    log("Bookmark", "false")
                }
            }
            false
        }
    }


    private fun initializeListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initializeAdapter() {
        val callback = object : ChangeChapterFragment {
            override fun change(chapters: ArrayList<LessonModel>, chapterTitle: String) {
                findNavController().navigate(
                    R.id.action_chapterFragment_to_lessonsFragment,
                    Bundle().apply {
                        putParcelableArrayList("chapters", chapters)
                        putString("chapterTitle", chapterTitle)
                    })
            }
        }
        val adapter = ChapterAdapter(callback)
        adapter.setData(chapterList)
        binding.chaptersRv.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}