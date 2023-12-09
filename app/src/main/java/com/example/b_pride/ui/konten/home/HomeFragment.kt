package com.example.b_pride.ui.konten.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.b_pride.R
import com.example.b_pride.data.remote.response.Product
import com.example.b_pride.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    private val viewModel: HomeViewModel by inject()
    private var listLaptop: List<Product> = listOf()
    private var listSmartphone: List<Product> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val username = arguments?.getString("username") ?: ""

        binding.logprofil.setOnClickListener {
            val bundle = Bundle().apply {
                putString("username", username)
            }
            findNavController().navigate(R.id.action_navigationParentFragment_to_profileFragment, bundle)
        }

        init()
        observeData()

        return binding.root
    }

    private fun observeLaptopData() {
        viewModel.observeLaptop.observe(viewLifecycleOwner) { data ->
            data?.let {
                listLaptop = it.body()?.products ?: listOf()
                binding.itemRv.adapter = HomeAdapter(listLaptop)
                binding.itemRv.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    private fun observeSmartphoneData() {
        viewModel.observeSmartphone.observe(viewLifecycleOwner) { data ->
            data?.let {
                listSmartphone = it.body()?.products ?: listOf()
                binding.itemRv1.adapter = HomeAdapter(listSmartphone)
                binding.itemRv1.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    private fun observeData() {
        observeLaptopData()
        observeSmartphoneData()
    }

    private fun init() {
        viewModel.getLaptop()
        viewModel.getSmartphone()
    }
}