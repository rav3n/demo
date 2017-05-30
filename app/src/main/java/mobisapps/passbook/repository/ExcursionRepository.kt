package mobisapps.passbook.repository

import com.butlerhero.app.kotlin.repository.BehaviorSubjectRepository
import mobisapps.passbook.entities.ExcursionEntity

class ExcursionRepository(default: List<ExcursionEntity> = listOf()) : BehaviorSubjectRepository<List<ExcursionEntity>>(default)
