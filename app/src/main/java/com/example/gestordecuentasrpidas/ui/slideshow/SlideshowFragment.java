package com.example.gestordecuentasrpidas.ui.slideshow;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.gestordecuentasrpidas.R;


public class SlideshowFragment extends Fragment {
    private VideoView videoView1;
    private VideoView videoView2;
    private VideoView videoView3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        videoView1 = root.findViewById(R.id.videoView1);
        videoView2 = root.findViewById(R.id.videoView2);
        videoView3 = root.findViewById(R.id.videoView3);

        // Configurar controles de reproducción para cada VideoView
        MediaController mediaController1 = new MediaController(getActivity());
        mediaController1.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController1);

        MediaController mediaController2 = new MediaController(getActivity());
        mediaController2.setAnchorView(videoView2);
        videoView2.setMediaController(mediaController2);

        MediaController mediaController3 = new MediaController(getActivity());
        mediaController3.setAnchorView(videoView3);
        videoView3.setMediaController(mediaController3);

        // Configura la ruta del primer video desde la carpeta raw
        videoView1.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video1));

        // Configura la ruta del segundo video desde la carpeta raw
        videoView2.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video2));

        // Configura la ruta del tercer video desde la carpeta raw
        videoView3.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video3));


        return root;
    }
}