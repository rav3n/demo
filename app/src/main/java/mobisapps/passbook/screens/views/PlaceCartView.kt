package mobisapps.passbook.screens.views

import com.hannesdorfmann.mosby3.mvp.MvpView
import mobisapps.passbook.entities.PlaceEntity

interface PlaceCartView: MvpView {
    fun renderData(place: PlaceEntity)
}

