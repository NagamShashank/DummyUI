package com.example.dummyui

import android.content.res.Resources.Theme
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.dummyui.databinding.Fragment2Binding

class Fragment_2 : Fragment() {

    private lateinit var fBinding : Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fBinding = Fragment2Binding.inflate(inflater,container,false)


        return fBinding.root
    }



}