package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.interface_.ChangeSubjectFragment
import com.example.byjusclone.R
import com.example.byjusclone.adapter.HomeMainAdapter
import com.example.byjusclone.databinding.FragmentHomeBinding
import com.example.byjusclone.model.ChapterModel
import com.example.byjusclone.model.HomeMainModel
import com.example.byjusclone.model.LessonModel
import com.example.byjusclone.model.SubjectModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var subjectData = ArrayList<HomeMainModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListener()
        initializeAdapter()
    }

    private fun initializeListener() {
        binding.topAppBar.setNavigationOnClickListener {
            openDrawer()
        }

    }

    private fun openDrawer() {
        binding.mainDrawerLayout.openDrawer(GravityCompat.START)
    }


    private fun initializeAdapter() {
        val callback = object : ChangeSubjectFragment {
            override fun change(chapters: ArrayList<ChapterModel>, subjectName: String) {
                findNavController().navigate(
                    R.id.action_homeFragment_to_chapterFragment,
                    Bundle().apply {
                        putParcelableArrayList("chapterList", chapters)
                        putString("subject", subjectName)
                    })
            }
        }
        val adapter = HomeMainAdapter(callback)
        adapter.setData(ArrayList<HomeMainModel>().apply {
            add(
                HomeMainModel("Subjects", "subject", ArrayList<SubjectModel>().apply {
                    add(
                        SubjectModel(
                            R.drawable.mathematics,
                            "Mathematics",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("0",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("1",
                                                    "https://i.imgur.com/OB0y6MR.jpg",
                                                    "Elephant Dream",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("2",
                                                    "https://farm2.staticflickr.com/1533/26541536141_41abe98db3_z_d.jpg",
                                                    "For Bigger Blazes",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("3",
                                                    "https://farm9.staticflickr.com/8505/8441256181_4e98d8bff5_z_d.jpg",
                                                    "For Bigger Escape",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                                add(
                                    ChapterModel(
                                        "Polynomials",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("4",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("5",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("6",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("7",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                                add(
                                    ChapterModel(
                                        "Polynomials",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("8",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("9",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("10",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("11",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("12",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("13",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("14",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("15",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                                add(
                                    ChapterModel(
                                        "Polynomials",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("16",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("17",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("18",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("19",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("20",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("21",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("22",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("23",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                                add(
                                    ChapterModel(
                                        "Polynomials",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("24",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("25",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("26",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("27",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("28",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("29",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                    add(
                        SubjectModel(
                            R.drawable.physics,
                            "Physics",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("30",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("31",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("432",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("034",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                    add(
                        SubjectModel(
                            R.drawable.chemistry,
                            "Chemistry",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("024",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                    add(
                        SubjectModel(
                            R.drawable.biologypng,
                            "Biology",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("065",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("063",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                            add(
                                                LessonModel("650",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                    add(
                        SubjectModel(
                            R.drawable.history,
                            "History",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("101",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                    add(
                        SubjectModel(
                            R.drawable.geography,
                            "Geography",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("090",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                    add(
                        SubjectModel(
                            R.drawable.civicspng,
                            "Civics",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("56",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                    add(
                        SubjectModel(
                            R.drawable.economic,
                            "Economics",
                            ArrayList<ChapterModel>().apply {
                                add(
                                    ChapterModel(
                                        "Real number",
                                        10,
                                        ArrayList<LessonModel>().apply {
                                            add(
                                                LessonModel("87",
                                                    "https://i.imgur.com/CzXTtJV.jpg",
                                                    "Big Buck Bunny",
                                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                                )
                                            )
                                        }
                                    )
                                )
                            })
                    )
                })
            )
        })
        binding.homeMainRv.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}