package com.example.b_pride.ui.konten.laptop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.b_pride.data.remote.response.Product
import com.example.b_pride.databinding.FragmentLaptopBinding
import org.koin.android.ext.android.inject


class LaptopFragment : Fragment() {
    private lateinit var _binding: FragmentLaptopBinding
    private val binding get() = _binding
    private val viewModel: LaptopViewModel by inject()
    private var list: List<Product> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLaptopBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeLaptop.observe(viewLifecycleOwner){
                it.let { data ->
                    list = data.body()?.products ?: listOf()
                    with(binding.rvLaptop1){
                        adapter = LaptopAdapter(list)
                        layoutManager = LinearLayoutManager(requireContext())
//                        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    }
                }
            }
        }
    }

    private fun init(){
        viewModel.getLaptop()
    }

}