package com.example.myapps.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapps.R
import com.example.myapps.adapters.GalleryAdapter

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        recyclerView = view.findViewById(R.id.galleryRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        val images = listOf(
            R.drawable.hold0,
            R.drawable.hold1,
            R.drawable.hold2,
            R.drawable.hold3,
            R.drawable.hold4,
            R.drawable.hold5,
            R.drawable.hold6,
            R.drawable.hold7,
            R.drawable.hold8,
            R.drawable.hold9,

        )

        adapter = GalleryAdapter(images)
        recyclerView.adapter = adapter

        return view
    }
}
