package mobisapps.passbook.screens.views

import com.hannesdorfmann.mosby3.mvp.MvpView
import mobisapps.passbook.entities.PlaceEntity

interface MapView: MvpView {
    fun renderPlaces(places: List<PlaceEntity>)
}

