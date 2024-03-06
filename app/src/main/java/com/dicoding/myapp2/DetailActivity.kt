package com.dicoding.myapp2

import android.media.Image
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    private lateinit var tvDetailTitle :TextView
    private lateinit var tvDetailDesc :TextView
    private lateinit var photoDetail :ImageView

    companion object{
        const val EXTRA_ARTICLE = "extra_article"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        tvDetailTitle = findViewById(R.id.tv_article_title)
        tvDetailDesc = findViewById(R.id.tv_article_desc)
        photoDetail = findViewById(R.id.photo_article)

        val dataArticle = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Article>(EXTRA_ARTICLE, Article::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Article>(EXTRA_ARTICLE)
        }

        if (dataArticle != null){
            tvDetailTitle.text = dataArticle.title
            tvDetailDesc.text = dataArticle.description
            photoDetail.setImageResource(dataArticle.photo)
        }
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}