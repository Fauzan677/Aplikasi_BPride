package com.example.b_pride.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.b_pride.R
import com.example.b_pride.databinding.FragmentForgotPasswordBinding
import com.example.b_pride.databinding.FragmentLoginBinding

class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener{
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
        }

        return binding.root
    }
}