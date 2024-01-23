package com.example.dummyui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummyui.databinding.Fragment2Binding
import com.example.dummyui.databinding.Fragment3Binding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF


class Fragment_3 : Fragment() {

    private lateinit var fBinding : Fragment3Binding
    private lateinit var itemList : ArrayList<ItemData>
    private lateinit var adapterItem : ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fBinding = Fragment3Binding.inflate(inflater,container,false)


        loadPieChart()
        loadList()
        loadRecyclerview()
        return fBinding.root
    }

    private fun loadList(){
        itemList = ArrayList()
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_5,"Nonsl truymp donald","rem","1286","Km"))
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_4,"Plusn","rem","488","Km"))
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_5,"Lorem","rem","128","Km"))
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_2,"Inpsm","rem","34","Km"))
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_3,"Better","rem","248","Km"))
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_1,"PBetter","rem","1356","Km"))
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_4,"Good","rem","1500","Km"))
        itemList.add(ItemData(R.drawable.sunset,R.drawable.win_3,"Exce","rem","100","Km"))
    }

    private fun loadRecyclerview(){
        adapterItem = ItemAdapter(requireContext(),itemList)
        fBinding.recyclerviewRank.adapter = adapterItem
        fBinding.recyclerviewRank.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadPieChart(){

        fBinding.pieChart.setUsePercentValues(true)
        fBinding.pieChart.description.isEnabled = false
        fBinding.pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        fBinding.pieChart.dragDecelerationFrictionCoef = 0.95f



        fBinding.pieChart.isDrawHoleEnabled = true
        fBinding.pieChart.setHoleColor(Color.TRANSPARENT)

        fBinding.pieChart.isDrawCenterTextEnabled
        fBinding.pieChart.centerText = generateCenterSpannableText("45\n Center")


        fBinding.pieChart.setTransparentCircleColor(Color.WHITE)
        fBinding.pieChart.setTransparentCircleAlpha(110)

        // on  below line we are setting hole radius
        fBinding.pieChart.holeRadius = 76f
        fBinding.pieChart.transparentCircleRadius = 61f


        fBinding.pieChart.rotationAngle = 0f


        fBinding.pieChart.isRotationEnabled = true
        fBinding.pieChart.isHighlightPerTapEnabled = true

        fBinding.pieChart.animateY(1400, Easing.EaseInOutQuad)


        fBinding.pieChart.legend.isEnabled = false

        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(0f))
        entries.add(PieEntry(6f))
        entries.add(PieEntry(14f))
        entries.add(PieEntry(22f))
        entries.add(PieEntry(5f))


        val dataSet = PieDataSet(entries, "Mobile OS")


        dataSet.setDrawIcons(false)


        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f


        val colors: ArrayList<Int> = ArrayList()

        colors.add(resources.getColor(R.color.purple_200))
        colors.add(resources.getColor(R.color.teal_200))
        colors.add(resources.getColor(R.color.yellow))
        colors.add(resources.getColor(R.color.red2))
        colors.add(resources.getColor(R.color.purple3))



        dataSet.colors = colors


        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setDrawValues(false)
        fBinding.pieChart.data = data


        fBinding.pieChart.highlightValues(null)


        fBinding.pieChart.invalidate()

    }


    private fun generateCenterSpannableText(text: String): SpannableString {
        val s = SpannableString(text)
        s.setSpan(RelativeSizeSpan(1.7f), 0, s.length, 0)
        s.setSpan(StyleSpan(Typeface.BOLD), 0, s.length, 0)
        s.setSpan(ForegroundColorSpan(Color.WHITE), 0, s.length, 0)
        s.setSpan(StyleSpan(Typeface.BOLD), 0, s.length, 0)
        return s
    }

}