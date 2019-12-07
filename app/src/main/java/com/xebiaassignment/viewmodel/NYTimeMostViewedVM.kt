package com.xebiaassignment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xebiaassignment.Base.BaseInterface
import com.xebiaassignment.Utils.Constant
import com.xebiaassignment.model.MostViewedArticlesResponse
import com.xebiaassignment.network.NYTimesAPI
import com.xebiaassignment.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NYTimeMostViewedVM : ViewModel(), BaseInterface {
    private val nyTimesAPI: NYTimesAPI = RetrofitService.createService(NYTimesAPI::class.java)
    var newsData: MutableLiveData<MostViewedArticlesResponse> = MutableLiveData()
    var showProgress : MutableLiveData<Boolean> = MutableLiveData()
    protected val compositeDisposables: CompositeDisposable = CompositeDisposable()

    override fun subscribe(subscribedDisposable: Disposable) {
       compositeDisposables.add(subscribedDisposable)
    }

    override fun unsubscribe() {
        compositeDisposables.clear()
    }

    fun getNews() {
        showProgress.value = true
       var result =  nyTimesAPI.getMostViewedArticles(Constant.API_KEY).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                newsData.value = it
                showProgress.value = false
            }, {
                newsData.value = null
                showProgress.value = false
                Log.e("error", it.message)
            }, {
                unsubscribe()
            })

        subscribe(result)
    }
}