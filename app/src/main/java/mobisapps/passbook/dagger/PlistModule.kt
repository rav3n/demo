package mobisapps.passbook.dagger

import dagger.Module
import dagger.Provides
import mobisapps.passbook.plist.PlistInteractor
import mobisapps.passbook.plist.PlistProvider
import mobisapps.passbook.repository.CategoryRepository
import mobisapps.passbook.repository.ExcursionRepository
import mobisapps.passbook.repository.PathRepository
import mobisapps.passbook.repository.PlaceRepository
import retrofit2.Retrofit

@Module
class PlistModule {

    @Provides fun provideInteractor(
        provider: PlistProvider,
        categoryRepository: CategoryRepository,
        excursionRepository: ExcursionRepository,
        pathRepository: PathRepository,
        placeRepository: PlaceRepository
    ) : PlistInteractor {
        return PlistInteractor(provider, categoryRepository, excursionRepository, pathRepository, placeRepository)
    }

    @Provides fun provediPlistProvider(retrofit: Retrofit): PlistProvider {
        return retrofit.create(PlistProvider::class.java)
    }
}