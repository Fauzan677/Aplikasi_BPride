package com.example.b_pride.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.b_pride.data.lokal.AppDatabase
import com.example.b_pride.data.lokal.User
import com.example.b_pride.databinding.FragmentProfileBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {
    private lateinit var appDb: AppDatabase
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inisialisasi database
        appDb = AppDatabase.getDatabase(requireContext())

        // Memanggil fungsi untuk membaca dan menampilkan data
        readData()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun readData() {
        GlobalScope.launch(Dispatchers.IO) {
            lateinit var user: User
            user = appDb.userDao().findByRoll()
            Log.d("Data", user.toString())
            withContext(Dispatchers.Main) {
                displayData(user)
            }
        }
    }

    private fun displayData(user: User) {
        binding.username.text = user.firstName
        binding.email.text = user.email
        binding.password.text = user.password
    }
}
