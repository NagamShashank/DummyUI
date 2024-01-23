package com.example.dummyui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyui.databinding.ListitemlayoutBinding

class ItemAdapter (val context: Context, val ItemList : ArrayList<ItemData>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    inner class ItemViewHolder( val listitemlayoutBinding: ListitemlayoutBinding): RecyclerView.ViewHolder(listitemlayoutBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        return ItemViewHolder(ListitemlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val model  = ItemList[position]

        holder.listitemlayoutBinding.apply {
            itemImg.setImageResource(model.itemImg)
            rankImg.setBackgroundResource(model.rankImg)
            rankTitle.text = model.rankTitle
            rankDesc.text = model.rankDesc
            kiloMeter.text = model.kiloMeter
            unitKm.text = model.unitKm
        }
    }

    override fun getItemCount(): Int { return ItemList.size}
}