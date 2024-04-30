package com.example.gestordecuentasrpidas.ui.slideshow

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.gestordecuentasrpidas.R

class SlideshowFragment : Fragment() {
    private lateinit var videoView1: VideoView
    private lateinit var videoView2: VideoView
    private lateinit var videoView3: VideoView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        videoView1 = root.findViewById(R.id.videoView1)
        videoView2 = root.findViewById(R.id.videoView2)
        videoView3 = root.findViewById(R.id.videoView3)

        // Configurar controles de reproducción para cada VideoView
        val mediaController1 = MediaController(requireActivity())
        mediaController1.setAnchorView(videoView1)
        videoView1.setMediaController(mediaController1)

        val mediaController2 = MediaController(requireActivity())
        mediaController2.setAnchorView(videoView2)
        videoView2.setMediaController(mediaController2)

        val mediaController3 = MediaController(requireActivity())
        mediaController3.setAnchorView(videoView3)
        videoView3.setMediaController(mediaController3)

        // Configura la ruta del primer video desde la carpeta raw
        videoView1.setVideoURI(Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.video1))

        // Configura la ruta del segundo video desde la carpeta raw
        videoView2.setVideoURI(Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.video2))

        // Configura la ruta del tercer video desde la carpeta raw
        videoView3.setVideoURI(Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.video3))

        return root
    }
}
