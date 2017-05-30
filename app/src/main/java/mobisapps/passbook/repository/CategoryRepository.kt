package mobisapps.passbook.repository

import com.butlerhero.app.kotlin.repository.BehaviorSubjectRepository
import mobisapps.passbook.entities.CategoryEntity
import rx.Observable

class CategoryRepository(default: List<CategoryEntity> = listOf()) : BehaviorSubjectRepository<List<CategoryEntity>>(default) {

    fun categoryById(id: Int) : Observable<CategoryEntity> {
        return toObservable().map { it.filter { it.id == id }.first() }
    }

}
