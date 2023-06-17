package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.R
import com.example.byjusclone.databinding.FragmentNumberEnterBinding
import com.example.byjusclone.utils.hideKeyboard
import com.example.byjusclone.utils.isValidMobileNumber
import com.example.byjusclone.utils.validation


class NumberEnterFragment : Fragment() {
    private var _binding: FragmentNumberEnterBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNumberEnterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        validation()

    }

    private fun validation() {
        binding.tilEnterNumber.validation { number ->
            binding.sendOtp.setOnClickListener {
                if (isValidMobileNumber(number, requireContext()).toString() == "null") {
                    binding.helperText.text = ""
                    hideKeyboard()
                    Toast.makeText(requireContext(), "next Fragment", Toast.LENGTH_SHORT).show()
                    findNavController()
                        .navigate(
                            R.id.action_numberEnterFragment_to_verifyFragment,
                            Bundle().apply {
                                putString("mobileNumber", binding.tilEnterNumber.text.toString())
                            })
                } else {
                    binding.helperText.text =
                        isValidMobileNumber(number, requireContext()).toString()
                }
            }
            if (number.length == 10) {
                hideKeyboard()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}