package com.xebiaassignment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.xebiaassignment.Base.navigateToNextActivity
import com.xebiaassignment.R
import com.xebiaassignment.model.MostViewedArticlesResponse
import com.xebiaassignment.view.ArticleDetailActivity


class MostPopulorArticlesAdapter(val activity: AppCompatActivity) :
    RecyclerView.Adapter<MostPopulorArticlesAdapter.NewsViewHolder>() {

    var articlesList: MutableList<MostViewedArticlesResponse.Result> = mutableListOf()

    fun addArticles(list: MutableList<MostViewedArticlesResponse.Result>) {
        articlesList.clear()
        articlesList = list
        notifyDataSetChanged()
    }

    fun cleardata() {
        if (articlesList != null) {
            articlesList.clear()
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopulorArticlesAdapter.NewsViewHolder {
        var binding =
            DataBindingUtil.inflate<com.xebiaassignment.databinding.ArticleItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.article_item,
                parent,
                false
            )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindData(articlesList[position], position)
    }

    inner class NewsViewHolder(var binding: com.xebiaassignment.databinding.ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(
            data: MostViewedArticlesResponse.Result,
            position: Int
        ) {
            binding.data = data
            binding.parentLayout.setOnClickListener{
                var intent = Intent(activity, ArticleDetailActivity::class.java)
                var gson = Gson()
                var articleDataInString = gson.toJson(data)
                intent.putExtra("articleDetails", articleDataInString)
                    navigateToNextActivity(activity,intent,false)
            }
        }
    }


}