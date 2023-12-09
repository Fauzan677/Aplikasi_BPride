package com.example.b_pride.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.b_pride.R
import com.example.b_pride.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeIsLogin().observe(requireActivity()){
                it.let{ data ->
                    if (data != null){
                        val bundle = Bundle().apply {
                            putString("username", binding.username.text.toString())
                        }
                        if (isAdded) {
                            findNavController().navigate(R.id.action_loginFragment_to_navigationParentFragment, bundle)
                        }
                    }
                }
            }
        }
    }

    private fun init(){
        with(binding){
            masuk.setOnClickListener{
                if(username.text.isNullOrBlank()){
                    username.error = "Email Kosong"
                }

                if(password.text.isNullOrBlank()){
                    password.error = "Password Kosong"
                }

                if(!username.text.isNullOrBlank() && !password.text.isNullOrBlank()){
                    viewModel.getDataLogin(username.text.toString(), password.text.toString())
                }
            }

            daftar.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }


}