package com.example.dummyui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummyui.databinding.Fragment1Binding


class Fragment_1 : Fragment() {

    private lateinit var fBinding : Fragment1Binding
    private lateinit var rankList : ArrayList<RankData>
    private lateinit var adapterRank : RankAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fBinding = Fragment1Binding.inflate(inflater,container,false)
        loadList()
        loadRecyclerView()
        return fBinding.root
    }

    private fun loadList(){
        rankList = ArrayList()
        rankList.add(RankData(R.drawable.win_1,"Rank 1","Lorem Ipsum is Excellent for printing "))
        rankList.add(RankData(R.drawable.win_2,"Rank 2","Lorem Ipsum is Fantastic for printing "))
        rankList.add(RankData(R.drawable.win_3,"Rank 3","Lorem Ipsum is Good and Better for printing "))
        rankList.add(RankData(R.drawable.win_4,"Rank 4","Lorem Ipsum is Better for printing "))
        rankList.add(RankData(R.drawable.win_5,"Rank 5","Lorem Ipsum is Good for printing "))
        }
    private fun loadRecyclerView(){
        adapterRank = RankAdapter(requireContext(),rankList)
        fBinding.rankRecyclerview.adapter = adapterRank
        fBinding.rankRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

}