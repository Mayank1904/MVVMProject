package com.xebiaassignment.Base

import io.reactivex.disposables.Disposable

interface BaseInterface {
    fun subscribe(subscribedDisposable: Disposable)
    fun unsubscribe()
}