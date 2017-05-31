package mobisapps.passbook.screens.presenters

import mobisapps.passbook.PassbookApplication
import mobisapps.passbook.repository.CategoryRepository
import mobisapps.passbook.repository.PlaceRepository
import mobisapps.passbook.screens.presenters.base.RxBasePresenter
import mobisapps.passbook.screens.views.PlaceListView
import javax.inject.Inject

class PlaceListPresenter(private val categoryId: Int) : RxBasePresenter<PlaceListView>() {
    init {
        PassbookApplication.graph.inject(this)
    }

    @Inject
    lateinit var categoryRepository: CategoryRepository

    @Inject
    lateinit var placeRepository: PlaceRepository

    override fun attachView(view: PlaceListView?) {
        super.attachView(view)
        addSubscriber(
            categoryRepository
                .categoryById(categoryId)
                .flatMap { placeRepository.placesByIds(it.places) }
                .subscribe(
                    {
                        if (isViewAttached) {
                            getView().showList(it)
                        }
                    },
                    {
                        it.printStackTrace()
                    }
                )
        )
    }
}