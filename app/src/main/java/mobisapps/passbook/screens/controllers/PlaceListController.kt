package mobisapps.passbook.screens.controllers

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import com.amurnet.coupon.v2.controllers.ButterKnifeController
import com.bluelinelabs.conductor.RouterTransaction
import com.hannesdorfmann.mosby3.mvp.MvpView
import mobisapps.passbook.R
import mobisapps.passbook.entities.PlaceEntity
import mobisapps.passbook.screens.adapters.PlaceListAdapter
import mobisapps.passbook.screens.presenters.PlaceListPresenter

class PlaceListController : ButterKnifeController<PlaceListView, PlaceListPresenter>, PlaceListView {

    private var id: Int = 0

    constructor(args: Bundle) : super(args)
    constructor(id: Int) : super() {
        this.id = id
    }

    @BindView(R.id.controller_place_list_recycler)
    lateinit var recycler: RecyclerView

    override fun inflate(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_place_list, container, false)
    }

    override fun createPresenter(): PlaceListPresenter {
        return PlaceListPresenter(id)
    }

    override fun showList(items: List<PlaceEntity>) {
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = PlaceListAdapter(items)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PlaceListController.javaClass.simpleName, id)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        id = savedInstanceState.getInt(PlaceListController.javaClass.simpleName, id)
    }

    companion object {
        fun routerTransaction(id: Int) : RouterTransaction {
            return RouterTransaction.with(PlaceListController(id))
        }
    }
}

interface PlaceListView : MvpView {
    fun showList(items: List<PlaceEntity>)
}