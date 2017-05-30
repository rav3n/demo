package mobisapps.passbook.screens.presenters.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import rx.Subscription
import rx.subscriptions.CompositeSubscription

open abstract class RxBasePresenter<V : MvpView?> : MvpBasePresenter<V>() {

    private val compositeSubscriber = CompositeSubscription()

    protected fun addSubscriber(subscription: Subscription) {
        compositeSubscriber.add(subscription)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        compositeSubscriber.clear()
    }
}