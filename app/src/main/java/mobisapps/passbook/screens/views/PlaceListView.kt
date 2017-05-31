package mobisapps.passbook.screens.views

import com.hannesdorfmann.mosby3.mvp.MvpView
import mobisapps.passbook.entities.PlaceEntity

interface PlaceListView : MvpView {
    fun showList(items: List<PlaceEntity>)
}
