package com.example.dummyui.UITask_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dummyui.databinding.FragmentHomeBinding


class Fragment_Home : Fragment() {

private var sBinding : FragmentHomeBinding? = null
    private val binding get() = sBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sBinding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

}