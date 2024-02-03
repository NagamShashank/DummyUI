package com.example.dummyui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.dummyui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moveToFragments()
        moveExplicit()
    }

    private fun moveToFragments(){

        binding.btnFragment1.setOnClickListener {
            val fragment = Fragment_1()
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnFragment2.setOnClickListener {
            val fragment = Fragment_2()
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnFragment3.setOnClickListener {
            val fragment = Fragment_3()
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

    private fun moveExplicit(){

        val bundle = Bundle()
        bundle.putString("Name","Shoeb Shaikh")
        bundle.putString("Contact","8087703241")

        binding.explicitBtn.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity3::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}