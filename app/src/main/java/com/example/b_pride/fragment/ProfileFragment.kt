package com.example.b_pride.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.b_pride.R
import com.example.b_pride.data.AppDatabase
import com.example.b_pride.data.User
import com.example.b_pride.databinding.FragmentProfileBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProfileFragment : Fragment() {
    private lateinit var appDb : AppDatabase

    private var _binding: FragmentProfileBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        _binding = ProfileFragment.inflate(R.layout.fragment_profile, container, false)
//        val view = binding.root
//        return view
////        return inflater.inflate(R.layout.fragment_profile, container, false)
//        readData()
//
//    }


    private fun readData(){

            lateinit var user: User

            GlobalScope.launch {


                user = appDb.userDao().findByRoll(3)
                Log.d("Data",user.toString())
                displayData(user)

            }

    }

    private suspend fun displayData(user: User){

        binding.username.text = user.firstName
        binding.email.text = user.email
        binding.password.text = user.password

    }

}