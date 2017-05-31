package mobisapps.passbook.screens.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amurnet.coupon.v2.controllers.ButterKnifeController
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import mobisapps.passbook.R
import mobisapps.passbook.entities.PlaceEntity
import mobisapps.passbook.screens.presenters.MapPresenter
import mobisapps.passbook.screens.views.MapView

class MapController : ButterKnifeController<MapView, MapPresenter>, MapView {

    constructor() : super ()
    constructor(args: Bundle) : super (args)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_map, container, false)
    }

    override fun createPresenter(): MapPresenter {
        return MapPresenter()
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        val mapFragment = activity!!.fragmentManager.findFragmentById(R.id.map_fragment) as MapFragment
        val fragmentManager = activity!!.fragmentManager
        fragmentManager.beginTransaction()
                .remove(mapFragment)
                .commit()
    }

    override fun renderPlaces(places: List<PlaceEntity>) {
        val mapFragment = activity!!.fragmentManager.findFragmentById(R.id.map_fragment) as MapFragment
        mapFragment.getMapAsync {
            val map = it
            val builder = LatLngBounds.builder()
            places.forEach {
                val pos = LatLng(it.lat.toDouble(), it.lon.toDouble())
                map.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_art)).position(pos))
                builder.include(pos)
            }
            it.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), activity!!.resources.getDimensionPixelOffset(R.dimen.map_padding)))
        }
    }

    companion object {
        fun routerTransaction() = RouterTransaction.with(MapController())
                .popChangeHandler(VerticalChangeHandler())
                .pushChangeHandler(VerticalChangeHandler())
    }
}

