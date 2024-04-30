package com.example.gestordecuentasrpidas.ui.galeria

import ImageGalleryAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestordecuentasrpidas.FullscreenImageActivity
import com.example.gestordecuentasrpidas.R


class GaleriaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_galeria, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)

        val imageIds = listOf(R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3,R.drawable.imagen4, R.drawable.imagen5, R.drawable.imagen6, R.drawable.imagen7, R.drawable.imagen8)
        val adapter = ImageGalleryAdapter(requireContext(), imageIds) { imageResId ->
            showImageFullscreen(imageResId)
        }
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        return root
    }

    private fun showImageFullscreen(imageResId: Int) {
        // Asumiendo que tienes una actividad para mostrar la imagen en tamaño completo
        FullscreenImageActivity.start(requireContext(), imageResId)
    }
}