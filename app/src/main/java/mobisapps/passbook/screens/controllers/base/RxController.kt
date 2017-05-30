package com.butlerhero.app.kotlin.core

import android.os.Bundle
import android.view.View
import com.amurnet.coupon.v2.controllers.ButterKnifeController
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import rx.Subscription
import rx.subscriptions.CompositeSubscription

abstract class RxController<V : MvpView?, P : MvpPresenter<V>?> : ButterKnifeController<V, P> {

    private val composite: CompositeSubscription = CompositeSubscription()

    constructor() : super()
    constructor(args: Bundle) : super(args)

    fun addSubscribtion(subscription: Subscription) {
        composite.add(subscription)
    }

    override fun onDestroyView(view: View) {
        composite.clear()
        super.onDestroyView(view)
    }
}