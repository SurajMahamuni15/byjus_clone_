package com.example.byjusclone.fragment

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.Constance.LESSON
import com.example.byjusclone.Constance.POSITION
import com.example.byjusclone.adapter.VideoPlayListAdapter
import com.example.byjusclone.databinding.FragmentVideoBinding
import com.example.byjusclone.interface_.ChangeLessonFragment
import com.example.byjusclone.model.LessonModel
import com.example.byjusclone.utils.hideToolbarAndClearFullScreen
import com.example.byjusclone.utils.oriantaionLandscape
import com.example.byjusclone.utils.oriantaionPortrait
import com.example.byjusclone.utils.showToolbarAndClearFullScreen
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource


class VideoFragment : Fragment() {
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private var exoPlayer: ExoPlayer? = null
    private var playerPosition = 0L
    private var position = 0
    private lateinit var lesson: ArrayList<LessonModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt(POSITION)!!
        lesson = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList(LESSON, LessonModel::class.java)!!
        } else {
            arguments?.getParcelableArrayList(LESSON)!!
        }
        binding.videoTitle.text = lesson[position].title
        initializeExoPlayer(lesson[position].videoUrl)
        initializeAdapter(position)
        initializeListeners()
    }

    private fun initializeAdapter(position: Int) {
        val callback = object : ChangeLessonFragment {
            override fun change(lesson: ArrayList<LessonModel>, position: Int) {
                initializeDataSourse(lesson[position].videoUrl, 0L)
                exoPlayer?.play()
            }
        }
        val adapter = VideoPlayListAdapter(callback)
        adapter.setData(lesson,position)
        binding.playListRv.adapter = adapter
    }


    private fun initializeExoPlayer(url: String) {
        exoPlayer = ExoPlayer.Builder(requireContext())
            .setSeekBackIncrementMs(10000)
            .setSeekForwardIncrementMs(10000)
            .build()
        binding.exoplayer.player = exoPlayer
        initializeDataSourse(url, playerPosition)
    }

    private fun initializeDataSourse(url: String, position: Long) {
        val defaultHttpDataSource = DefaultHttpDataSource.Factory()
        val mediaItem = MediaItem.fromUri(url)
        val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSource)
            .createMediaSource(mediaItem)
        exoPlayer?.apply {
            setMediaSource(mediaSource)
            seekTo(position)
            playWhenReady = playWhenReady
            playWhenReady = true
            prepare()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            hideToolbarAndClearFullScreen()
            changeGuideLinePercent(1f, View.GONE)
        } else {
            showToolbarAndClearFullScreen()
            changeGuideLinePercent(0.30f, View.VISIBLE)
        }
    }

    private fun changeGuideLinePercent(percent: Float, visibility: Int) {
        binding.backBtn.visibility = visibility
        val params = binding.guideline3.layoutParams as ConstraintLayout.LayoutParams
        params.guidePercent = percent
        binding.guideline3.layoutParams = params
        binding.exoplayer.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
    }

    private fun setVisibility(flag: Boolean) {
        if (flag) {
            binding.exoplayer.visibility = View.VISIBLE
            binding.progressBar.progressBar.visibility = View.GONE
        } else {
            binding.exoplayer.visibility = View.GONE
            binding.progressBar.progressBar.visibility = View.VISIBLE
        }
    }

    private fun setProgressBarVisibility(flag: Boolean) {
        if (flag) {
            binding.progressBar.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.progressBar.visibility = View.GONE
        }
    }

    private fun initializeListeners() {
        binding.screenRotation.setOnClickListener {
            if (it.resources.configuration.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                oriantaionLandscape()
            } else {
                oriantaionPortrait()
            }
        }
        exoPlayer?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                when (playbackState) {
                    ExoPlayer.STATE_BUFFERING -> {
                        setProgressBarVisibility(true)
                    }

                    ExoPlayer.STATE_ENDED -> {
                        setProgressBarVisibility(false)
                    }

                    ExoPlayer.STATE_IDLE -> {
                        setProgressBarVisibility(false)
                    }

                    ExoPlayer.STATE_READY -> {
                        setVisibility(true)
                    }
                }
            }
        })
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        showToolbarAndClearFullScreen()
        exoPlayer?.release()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        exoPlayer?.pause()
    }

    override fun onPause() {
        super.onPause()
        oriantaionPortrait()
        exoPlayer?.pause()
    }



}