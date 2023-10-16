package com.example.b_pride.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.b_pride.R
import com.example.b_pride.databinding.FragmentCobaBinding


class CobaFragment : Fragment() {

    private var _binding : FragmentCobaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCobaBinding.inflate(inflater, container, false)
        binding.btnMsk.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_cobaFragment_to_homeFragment)
        }
        return binding.root
    }

}