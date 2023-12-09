package com.example.b_pride.ui.konten

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.b_pride.R
import com.example.b_pride.databinding.FragmentNavigationParentBinding
import com.example.b_pride.ui.konten.home.HomeFragment
import com.example.b_pride.ui.konten.laptop.LaptopFragment
import com.example.b_pride.ui.konten.smartphone.SmartphoneFragment

class NavigationParentFragment : Fragment() {
    private var _binding: FragmentNavigationParentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationParentBinding.inflate(inflater, container, false)
        val username = arguments?.getString("username") ?: ""

        val homeFragment = HomeFragment().apply {
            arguments = Bundle().apply {
                putString("username", username.orEmpty())
            }
        }

        val SmartphoneFragment = SmartphoneFragment()
        val LaptopFragment = LaptopFragment()


        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.produk -> setCurrentFragment(SmartphoneFragment)
                R.id.profile -> setCurrentFragment(LaptopFragment)
            }
            true
        }
        return binding.root
    }

    private fun setCurrentFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.parent_fragment, fragment)
            commit()
        }
    }

}