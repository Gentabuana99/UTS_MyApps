package com.example.myapps.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapps.R
import com.example.myapps.model.MusicItem

class MusicAdapter(
    private val listMusic: List<MusicItem>,
    private val onAudioClick: (MusicItem) -> Unit,
    private val onVideoClick: (MusicItem) -> Unit
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val txtName: TextView = itemView.findViewById(R.id.txt_item_name)
        val txtDeskripsi: TextView = itemView.findViewById(R.id.txt_item_deskripsi)
        val btnAudio: ImageView = itemView.findViewById(R.id.btn_audio)
        val btnVideo: ImageView = itemView.findViewById(R.id.btn_video)

        fun bind(music: MusicItem) {
            imgPhoto.setImageResource(music.imageResId)
            txtName.text = music.title
            txtDeskripsi.text = music.description
            btnAudio.setOnClickListener { onAudioClick(music) }
            btnVideo.setOnClickListener { onVideoClick(music) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(listMusic[position])
    }

    override fun getItemCount(): Int = listMusic.size
}