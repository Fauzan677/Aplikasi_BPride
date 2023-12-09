package com.example.b_pride.ui.konten.smartphone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.b_pride.data.remote.response.Product
import com.example.b_pride.databinding.FragmentSmartphoneBinding
import org.koin.android.ext.android.inject


class SmartphoneFragment : Fragment() {
    private lateinit var _binding: FragmentSmartphoneBinding
    private val binding get() = _binding
    private val viewModel: SmartphoneViewModel by inject()
    private var list: List<Product> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSmartphoneBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeSmartphone.observe(viewLifecycleOwner){  // Menggunakan viewLifecycleOwner
                it.let { data ->
                    list = data.body()?.products ?: listOf()
                    with(binding.rvProduct1){
                        adapter = SmartphoneAdapter(list)
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }

    private fun init(){
        viewModel.getSmartphone()
    }

}