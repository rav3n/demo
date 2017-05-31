package mobisapps.passbook.screens.presenters

import mobisapps.passbook.PassbookApplication
import mobisapps.passbook.repository.PlaceRepository
import mobisapps.passbook.screens.presenters.base.RxBasePresenter
import mobisapps.passbook.screens.views.PlaceCartView
import javax.inject.Inject

class PlaceCartPresenter(private val placeId: Int) : RxBasePresenter<PlaceCartView>() {
    init {
        PassbookApplication.graph.inject(this)
    }

    @Inject
    lateinit var placeRepository: PlaceRepository

    override fun attachView(view: PlaceCartView?) {
        super.attachView(view)
        addSubscriber(
                placeRepository.placesById(placeId).subscribe(
                        {
                            if (isViewAttached) {
                                getView().renderData(it)
                            }
                        },
                        {
                            it.printStackTrace()
                        }
                )
        )
    }
}
