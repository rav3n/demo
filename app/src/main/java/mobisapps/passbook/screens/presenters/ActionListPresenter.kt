package mobisapps.passbook.screens.presenters

import mobisapps.passbook.PassbookApplication
import mobisapps.passbook.repository.CategoryRepository
import mobisapps.passbook.screens.controllers.ActionListView
import mobisapps.passbook.screens.presenters.base.RxBasePresenter
import javax.inject.Inject

class ActionListPresenter : RxBasePresenter<ActionListView>() {
    init {
        PassbookApplication.graph.inject(this)
    }

    @Inject
    lateinit var categoryRepository: CategoryRepository

    override fun attachView(view: ActionListView?) {
        super.attachView(view)
        addSubscriber(
            categoryRepository.toObservable().subscribe(
                    {
                        if (isViewAttached) {
                            getView().showCategory(it)
                        }
                    },
                    { it.printStackTrace() }
            )
        )
    }
}

