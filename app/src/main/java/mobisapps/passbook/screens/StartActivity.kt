package mobisapps.passbook.screens

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import mobisapps.passbook.PassbookApplication
import mobisapps.passbook.R
import rx.schedulers.Schedulers
import mobisapps.passbook.plist.PlistInteractor
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class StartActivity : AppCompatActivity() {

    @Inject
    lateinit var interactor: PlistInteractor

    private lateinit var subscription: Subscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        subscription = Observable.just(this)
                .doOnSubscribe { progressBarVisibility(true) }
                .observeOn(Schedulers.io())
                .doOnNext{ PassbookApplication.graph.inject(this) }
                .flatMap { interactor.loadAndCacheData() }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { progressBarVisibility(false) }
                .subscribe(
                    {
                        finish()
                        ActionListActivity.start(applicationContext)
                    },
                    {
                        it.printStackTrace()
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_LONG).show()
                    }
                )
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.unsubscribe()
    }

    fun progressBarVisibility(visible: Boolean) {
        val view = findViewById(R.id.activity_start_progress_container)
        if (visible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.INVISIBLE
        }
    }
}