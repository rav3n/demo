package mobisapps.passbook.screens.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import com.amurnet.coupon.v2.controllers.ButterKnifeController
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import mobisapps.passbook.R
import mobisapps.passbook.entities.PlaceEntity
import mobisapps.passbook.screens.presenters.PlaceCartPresenter
import mobisapps.passbook.screens.views.PlaceCartView

class PlaceCartController : ButterKnifeController<PlaceCartView, PlaceCartPresenter>, PlaceCartView {

    private var placeId: Int = 0
    constructor(args: Bundle) : super(args)
    constructor(id: Int) : super() {
        placeId = id
    }

    @BindView(R.id.controller_place_cart_title)
    lateinit var titleView: TextView

    @BindView(R.id.controller_place_cart_description)
    lateinit var descriptionView: TextView

    override fun inflate(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_place_cart, container, false)
    }

    override fun createPresenter(): PlaceCartPresenter {
        return PlaceCartPresenter(placeId)
    }

    override fun renderData(place: PlaceEntity) {
        titleView.text = place.name
        descriptionView.text = place.details
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        placeId = savedInstanceState.getInt(PlaceCartController.javaClass.simpleName)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PlaceCartController.javaClass.simpleName, placeId)
    }

    companion object {
        fun routerTransaction(id: Int) : RouterTransaction {
            return RouterTransaction.with(PlaceCartController(id))
                    .popChangeHandler(HorizontalChangeHandler())
                    .pushChangeHandler(HorizontalChangeHandler())
        }
    }
}

