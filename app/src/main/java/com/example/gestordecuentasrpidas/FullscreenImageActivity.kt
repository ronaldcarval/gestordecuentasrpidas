package com.example.gestordecuentasrpidas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FullscreenImageActivity : AppCompatActivity() {

    companion object {
        private const val IMAGE_RES_ID = "imageResId"

        fun start(context: Context, imageResId: Int) {
            val intent = Intent(context, FullscreenImageActivity::class.java).apply {
                putExtra(IMAGE_RES_ID, imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen_image)

        val imageResId = intent.getIntExtra(IMAGE_RES_ID, 0)
        findViewById<ImageView>(R.id.fullscreenImageView).setImageResource(imageResId)
    }
}
