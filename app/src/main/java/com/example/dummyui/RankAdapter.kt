package com.example.dummyui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyui.databinding.RanksitemlayoutBinding

class RankAdapter(val context: Context,val listRank :ArrayList<RankData>): RecyclerView.Adapter<RankAdapter.ViewHolder>() {

    inner class ViewHolder(val itemlayoutbinding : RanksitemlayoutBinding):RecyclerView.ViewHolder(itemlayoutbinding.root){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankAdapter.ViewHolder {
        return ViewHolder(RanksitemlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RankAdapter.ViewHolder, position: Int) {
        val model = listRank[position]
        holder.itemlayoutbinding.apply {
            itemImg.setImageResource(model.image)
            itemTitleTxt.text = model.titleTxt
            itemDescTitleTxt.text = model.desTxt
        }
    }

    override fun getItemCount(): Int { return listRank.size }
}