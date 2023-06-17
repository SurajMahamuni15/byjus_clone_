package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.R
import com.example.byjusclone.adapter.LoginImageAdapter
import com.example.byjusclone.databinding.FragmentLoginBinding
import com.example.byjusclone.fragment.onBoardingFragments.FirstOnBoardingFragment
import com.example.byjusclone.fragment.onBoardingFragments.SecondOnBoardingFragment
import com.example.byjusclone.fragment.onBoardingFragments.ThirdOnBoardingFragment
import com.example.onboardingscreen.customPageTransformer.DepthPageTransformer
import com.google.android.material.tabs.TabLayoutMediator

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeImagesAdapter()
        initializeListener()

    }

    private fun initializeListener() {
        binding.tilEnterNumber.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_numberEnterFragment)
        }
    }

    private fun initializeImagesAdapter() {
        val fragmentList = arrayListOf(
            FirstOnBoardingFragment(),
            SecondOnBoardingFragment(),
            ThirdOnBoardingFragment()
        )
        val adapter =
            LoginImageAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.onBoardingPager.adapter = adapter
        TabLayoutMediator(
            binding.tabLayout,
            binding.onBoardingPager
        ) { tab, position -> }.attach()
        binding.onBoardingPager.setPageTransformer(DepthPageTransformer())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}