package com.xebiaassignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.xebiaassignment.R
import com.xebiaassignment.model.MostViewedArticlesResponse
import kotlinx.android.synthetic.main.activity_article.*

/**
 * An activity representing a single ArticleDetail detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ArticleDetailListActivity].
 */
class ArticleDetailActivity : AppCompatActivity() {
    var gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_article)
        var binding =
            DataBindingUtil.setContentView<com.xebiaassignment.databinding.ActivityArticleBinding>(
                this,
                R.layout.activity_article
            )
        setSupportActionBar(detail_toolbar)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var intentData = intent.getStringExtra("articleDetails")
        if(intentData != null) {
            var articleData = gson.fromJson<MostViewedArticlesResponse.Result>(
                intentData,
                MostViewedArticlesResponse.Result::class.java
            )
            if(articleData != null){
                binding.detail = articleData
            }
        }


        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
    }
}
