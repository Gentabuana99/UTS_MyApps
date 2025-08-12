package com.example.myapps.fragments

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapps.R
import com.example.myapps.adapters.MusicAdapter
import com.example.myapps.model.MusicItem

class MusicFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var videoView: VideoView
    private lateinit var rvMusic: RecyclerView
    private lateinit var btnStop: Button

    private val musicList = listOf(
        MusicItem(
            "Metallica",
            "One.",
            R.drawable.metallica,
            R.raw.one,
            R.raw.one_video // video untuk lagu Metallica
        ),
        MusicItem(
            "Gun N' Roses",
            "Don't Cry",
            R.drawable.gnr,
            R.raw.dontcry,
            R.raw.dontcry_video
        ),
        MusicItem(
            "Dream Theater",
            "The Spirit Carries On.",
            R.drawable.dt,
            R.raw.spiritcarrieson,
            R.raw.spiritcarrieson_video
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)

        videoView = view.findViewById(R.id.videoView)
        rvMusic = view.findViewById(R.id.rvMusic)
        btnStop = view.findViewById(R.id.btnStop)

        rvMusic.layoutManager = LinearLayoutManager(context)
        rvMusic.adapter = MusicAdapter(
            musicList,
            onAudioClick = { music ->
                stopAll()
                mediaPlayer = MediaPlayer.create(context, music.audioResId)
                mediaPlayer?.start()
                Toast.makeText(context, "Memutar audio: ${music.title}", Toast.LENGTH_SHORT).show()
            },
            onVideoClick = { music ->
                stopAll()
                val videoUri = Uri.parse("android.resource://${requireContext().packageName}/${music.videoResId}")
                videoView.setVideoURI(videoUri)
                videoView.seekTo(1)
                videoView.start()
                Toast.makeText(context, "Memutar video: ${music.title}", Toast.LENGTH_SHORT).show()
            }
        )

        val controller = MediaController(requireContext())
        controller.setAnchorView(videoView)
        videoView.setMediaController(controller)

        btnStop.setOnClickListener {
            stopAll()
            Toast.makeText(context, "Audio/Video dihentikan", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private fun stopAll() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
        }
        mediaPlayer = null

        if (videoView.isPlaying) {
            videoView.stopPlayback()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopAll()
    }
}