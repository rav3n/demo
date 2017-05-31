package mobisapps.passbook.screens.presenters

import mobisapps.passbook.PassbookApplication
import mobisapps.passbook.repository.PlaceRepository
import mobisapps.passbook.screens.presenters.base.RxBasePresenter
import mobisapps.passbook.screens.views.MapView
import javax.inject.Inject

class MapPresenter: RxBasePresenter<MapView>() {
    init {
        PassbookApplication.graph.inject(this)
    }

    @Inject
    lateinit var placeRepository: PlaceRepository

    override fun attachView(view: MapView?) {
        super.attachView(view)
        addSubscriber(
            placeRepository.toObservable().subscribe(
                    {
                        if (isViewAttached) {
                            getView().renderPlaces(it)
                        }
                    },
                    {
                        it.printStackTrace()
                    }
            )
        )
    }
}
