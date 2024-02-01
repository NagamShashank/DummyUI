package com.example.dummyui.UITask_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.dummyui.R
import com.example.dummyui.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Fragment_Home())

        binding.bottomNavigation.setOnItemSelectedListener {
            it.isChecked = true

            when(it.itemId){
                R.id.navigation_home ->{replaceFragment(Fragment_Home())}
                R.id.navigation_dashboard ->{replaceFragment(Fragment_Dashboard())}
                R.id.navigation_notify ->{replaceFragment(Fragment_Notify())}
                R.id.navigation_profile ->{replaceFragment(Fragment_Profile())}
            }

            true
        }

    }

    fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}