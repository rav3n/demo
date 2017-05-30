package mobisapps.passbook.repository

import com.butlerhero.app.kotlin.repository.BehaviorSubjectRepository
import mobisapps.passbook.entities.PathEntity

class PathRepository(default: List<PathEntity> = listOf()) : BehaviorSubjectRepository<List<PathEntity>>(default)
