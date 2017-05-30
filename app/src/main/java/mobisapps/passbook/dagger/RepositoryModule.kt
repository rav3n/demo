package mobisapps.passbook.dagger

import dagger.Module
import dagger.Provides
import mobisapps.passbook.repository.CategoryRepository
import mobisapps.passbook.repository.ExcursionRepository
import mobisapps.passbook.repository.PathRepository
import mobisapps.passbook.repository.PlaceRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton @Provides fun provideCategory() = CategoryRepository()
    @Singleton @Provides fun provideExcursion() = ExcursionRepository()
    @Singleton @Provides fun providePath() = PathRepository()
    @Singleton @Provides fun providePlaces() = PlaceRepository()
}