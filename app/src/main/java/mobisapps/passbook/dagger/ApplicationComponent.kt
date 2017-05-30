package mobisapps.passbook.dagger

import dagger.Component
import mobisapps.passbook.screens.StartActivity
import mobisapps.passbook.screens.controllers.ActionListController
import mobisapps.passbook.screens.presenters.ActionListPresenter
import mobisapps.passbook.screens.presenters.PlaceListPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ContextModule::class,
    NetworkModule::class,
    PlistModule::class,
    RepositoryModule::class
))
interface ApplicationComponent {
    fun inject(startActivity: StartActivity)
    fun inject(startActivity: ActionListPresenter)
    fun inject(placeListPresenter: PlaceListPresenter)
}