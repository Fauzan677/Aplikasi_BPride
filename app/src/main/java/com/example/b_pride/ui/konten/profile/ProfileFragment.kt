package com.example.b_pride.ui.konten.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.b_pride.R
import com.example.b_pride.data.lokal.AppDatabase
import com.example.b_pride.data.lokal.entity.User
import com.example.b_pride.databinding.FragmentProfileBinding
import com.example.b_pride.ui.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        val username = arguments?.getString("username") ?: ""

//        binding.keluar.setOnClickListener{
//            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
//        }

        binding.back.setOnClickListener{
            val bundle = Bundle().apply {
                putString("username", username)
            }
            findNavController().navigate(R.id.action_profileFragment_to_navigationParentFragment, bundle)
        }

        // Memanggil fungsi untuk membaca dan menampilkan data
        readData(username)

        return view
    }

    private fun readData(username: String) {
        viewModel.getDataProfile(username)
        displayData()
    }

    private fun displayData() {
        with(viewModel){
            observeprofile().observe(viewLifecycleOwner){
                it.let{ data ->
                    binding.username.text = data.firstName
                    binding.email.text = data.email
                    binding.password.text = data.password
                }
            }
        }

    }
}
