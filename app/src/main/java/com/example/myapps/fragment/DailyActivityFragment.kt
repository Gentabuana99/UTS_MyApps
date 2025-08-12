package com.example.myapps.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapps.R
import com.example.myapps.adapters.DailyAdapter
import com.example.myapps.models.DailyItem

class DailyFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_daily_activity, container, false)

        recyclerView = view.findViewById(R.id.recyclerDaily)

        val dummyList = listOf(
            DailyItem("Bangun Tidur", "Antara Pagi dan Siang"),
            DailyItem("Belajar", "Mempelajari arti hidup dan berguna untuk orang lain"),
            DailyItem("Hobby", "Touring dan Nongkrong"),
            DailyItem("Istirahat", "Memikirkan hari esok ")
        )

        recyclerView.adapter = DailyAdapter(dummyList)

        return view
    }
}
