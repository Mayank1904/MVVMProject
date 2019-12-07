package com.xebiaassignment.network

import com.xebiaassignment.model.MostViewedArticlesResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesAPI {
    @GET("mostpopular/v2/viewed/7.json")
    fun getMostViewedArticles(@Query("api-key") apiKey : String): Flowable<MostViewedArticlesResponse>
}