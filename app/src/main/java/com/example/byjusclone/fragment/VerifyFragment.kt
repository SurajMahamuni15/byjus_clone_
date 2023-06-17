package com.example.byjusclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.byjusclone.R
import com.example.byjusclone.custom.GenericKeyEvent
import com.example.byjusclone.custom.GenericTextWatcher
import com.example.byjusclone.databinding.FragmentVerifyBinding


class VerifyFragment : Fragment() {
    private var _binding: FragmentVerifyBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVerifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("mobileNumber").let {
            binding.number.text = getString(R.string._91_, it)
        }
        otpMoveNext()
        binding.getOtpOnCall.setOnClickListener {
            findNavController().navigate(R.id.action_verifyFragment_to_settingUpFragment)
        }
    }

    private fun otpMoveNext() {
        binding.textInputEditText.addTextChangedListener(
            GenericTextWatcher(
                binding.textInputEditText,
                binding.textInputEditText2
            )
        )
        binding.textInputEditText2.addTextChangedListener(
            GenericTextWatcher(
                binding.textInputEditText2,
                binding.textInputEditText3
            )
        )
        binding.textInputEditText3.addTextChangedListener(
            GenericTextWatcher(
                binding.textInputEditText3,
                binding.textInputEditText4
            )
        )
        binding.textInputEditText4.addTextChangedListener(
            GenericTextWatcher(
                binding.textInputEditText4,
                null
            )
        )

        binding.textInputEditText.setOnKeyListener(
            GenericKeyEvent(
                binding.textInputEditText, null
            )
        )
        binding.textInputEditText2.setOnKeyListener(
            GenericKeyEvent(
                binding.textInputEditText2,
                binding.textInputEditText
            )
        )
        binding.textInputEditText3.setOnKeyListener(
            GenericKeyEvent(
                binding.textInputEditText3,
                binding.textInputEditText2
            )
        )
        binding.textInputEditText4.setOnKeyListener(
            GenericKeyEvent(
                binding.textInputEditText4,
                binding.textInputEditText3
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}