package com.example.gestordecuentasrpidas.ui.web;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.gestordecuentasrpidas.R;

public class WebFragment extends Fragment {
    private WebView webView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtén una referencia al WebView desde el layout
        webView = view.findViewById(R.id.webView);

        // Configura las opciones del WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilita JavaScript

        // Carga una URL específica en el WebView
        webView.loadUrl("https://www.frubana.com/bog/Abarrotes");
    }
}