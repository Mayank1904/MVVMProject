package com.xebiaassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.xebiaassignment.R
import com.xebiaassignment.adapter.MostPopulorArticlesAdapter

import com.xebiaassignment.viewmodel.NYTimeMostViewedVM
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewedVM: NYTimeMostViewedVM
    lateinit var adapter: MostPopulorArticlesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewedVM = ViewModelProviders.of(this).get(NYTimeMostViewedVM::class.java)
        setupRecyclerView()
        listenToAPIResponse()
        listenToProgressBar()
        viewedVM.getNews()
    }

    private fun listenToAPIResponse() {
        viewedVM.newsData.observe(this, Observer {
            if (it != null)
                adapter.addArticles(it.results.toMutableList())
            else {
                Toast.makeText(this,"No Data Found",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = MostPopulorArticlesAdapter(this@MainActivity)
        articlesRv.layoutManager = LinearLayoutManager(this)
        articlesRv.adapter = adapter
        articlesRv.itemAnimator = DefaultItemAnimator()
        articlesRv.isNestedScrollingEnabled = true

    }

    private fun listenToProgressBar(){
        viewedVM.showProgress.observe(this, Observer {
            if(it){
                progressBar.visibility = View.VISIBLE
            }
            else
                progressBar.visibility = View.GONE
        })
    }
}
