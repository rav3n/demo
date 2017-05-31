package mobisapps.passbook.repository

import com.butlerhero.app.kotlin.repository.BehaviorSubjectRepository
import mobisapps.passbook.entities.PlaceEntity
import rx.Observable

class PlaceRepository(default: List<PlaceEntity> = listOf()) : BehaviorSubjectRepository<List<PlaceEntity>>(default) {
    fun placesByIds(places: List<Int>): Observable<List<PlaceEntity>> {
        return toObservable().map { it.filter { places.contains(it.id) } }
    }

    fun placesById(id: Int): Observable<PlaceEntity> {
        return toObservable().map { it.filter { it.id == id }.first() }
    }
}
