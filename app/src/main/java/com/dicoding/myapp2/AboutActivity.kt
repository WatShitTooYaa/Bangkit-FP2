package com.dicoding.myapp2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {

    private lateinit var aboutName: TextView
    private lateinit var aboutTTL: TextView
    private lateinit var aboutPhoto: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        aboutName = findViewById(R.id.about_name)
        aboutTTL = findViewById(R.id.about_ttl)
        aboutPhoto = findViewById(R.id.about_photo)

        aboutName.text = "Arkan Hendri A.G.B"
        aboutTTL.text = "Madiun, 21 September 2002"
        aboutPhoto.setImageResource(R.drawable.fotoku)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}