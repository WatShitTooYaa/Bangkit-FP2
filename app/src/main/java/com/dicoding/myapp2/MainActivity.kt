package com.dicoding.myapp2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvArticle: RecyclerView
    private val list = ArrayList<Article>()
//    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        rvArticle = findViewById(R.id.rv_article)
        rvArticle.setHasFixedSize(true)

        list.addAll(getListArticle())
        showRecyclerList()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list -> {
                rvArticle.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvArticle.layoutManager = GridLayoutManager(this, 2)
            }

            R.id.action_about -> {
                val about = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(about)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListArticle() : ArrayList<Article>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listArticle = ArrayList<Article>()
        for (i in dataName.indices){
            val article = Article(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listArticle.add(article)
        }
        return listArticle
    }

    private fun showRecyclerList(){
        rvArticle.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = ListArticleAdapter(list)
        rvArticle.adapter = listArticleAdapter

        listArticleAdapter.setOnItemClickCallback(object: ListArticleAdapter.OnItemClickCallback {
            override fun onItemClicked(data :Article){
                showSelectedArticle(data)
            }
        })
    }

    private fun showSelectedArticle(article: Article){
        Toast.makeText(this, "Kamu memilih " +article.title, Toast.LENGTH_LONG).show()

    }
}