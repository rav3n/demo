package mobisapps.passbook

import android.app.Application
import mobisapps.passbook.dagger.ApplicationComponent
import mobisapps.passbook.dagger.ContextModule
import mobisapps.passbook.dagger.DaggerApplicationComponent

class PassbookApplication : Application() {

    companion object {
        @JvmStatic lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }
}