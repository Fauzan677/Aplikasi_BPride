package com.example.b_pride.nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.b_pride.R
import com.example.b_pride.databinding.ActivityNavigationBinding
import com.example.b_pride.fragment.HomeFragment
import com.example.b_pride.fragment.ProductFragment
import com.example.b_pride.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class navigation : AppCompatActivity() {

    lateinit var binding : ActivityNavigationBinding

    val fragmentHome : Fragment = HomeFragment()
    val fragmentProfile : Fragment = ProfileFragment()
    val fragmentProduct : Fragment = ProductFragment()
    val fm : FragmentManager = supportFragmentManager

    var active : Fragment = fragmentHome
    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_navigation)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonNavigation ()
    }

    private fun buttonNavigation() {
//        disni kita akan memanggil fragment" nya
//        yang ketika buttonnya diklik dia akan menampilkan  apa
//        disini kita akan memanggil gimana kita akan menampilkan kontennya
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
//        maksudnya dihide karena yang tampil pertam buka ini jadi di sembunyikam
        fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile).commit()
        fm.beginTransaction().add(R.id.container, fragmentProduct).hide(fragmentProduct).commit()

//        Selanjutnya kita akan membuat jika klik icon home dia akn manggil fragemnt home dst
        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
//        0 artinya index yang pertama yaitu home dikasih index 0
//        selanjutnya mengatur jika di klik warnanya akan hidup
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when (item.itemId) {
                R.id.home -> {
                    callFragment(0,fragmentHome)
                }
                R.id.produk -> {
                    callFragment(1,fragmentProduct)
                }
                R.id.profile -> {
                    callFragment(2,fragmentProfile)
                }
            }
            false
        }
    }

    private fun callFragment(index : Int, fragment: Fragment) {
        menuItem = menu.getItem(index)
//        yang berarti jika dia di klik dia akan nyala
        menuItem.isChecked = true
//        ini maksudnya jika mengeklik timbol lain maka yang active pertama yaitu home akan hide
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}