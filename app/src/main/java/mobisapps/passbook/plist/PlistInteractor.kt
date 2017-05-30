package mobisapps.passbook.plist

import com.butlerhero.app.kotlin.repository.BehaviorSubjectRepository
import com.longevitysoft.android.xml.plist.PListXMLHandler
import com.longevitysoft.android.xml.plist.PListXMLParser
import com.longevitysoft.android.xml.plist.domain.Array
import com.longevitysoft.android.xml.plist.domain.Dict
import com.longevitysoft.android.xml.plist.domain.PList
import mobisapps.passbook.entities.CategoryEntity
import mobisapps.passbook.entities.ExcursionEntity
import mobisapps.passbook.entities.PathEntity
import mobisapps.passbook.entities.PlaceEntity
import mobisapps.passbook.repository.CategoryRepository
import mobisapps.passbook.repository.ExcursionRepository
import mobisapps.passbook.repository.PathRepository
import mobisapps.passbook.repository.PlaceRepository
import rx.Observable

class PlistInteractor(
    val provider: PlistProvider,
    val categoryRepository: CategoryRepository,
    val excursionRepository: ExcursionRepository,
    val pathRepository: PathRepository,
    val placeRepository: PlaceRepository
) {
    fun loadAndCacheData() : Observable<Boolean> {
        return provider.getPlist()
                .doOnNext {
                    val root: Dict = toPlist(it).rootElement as Dict
                    categoryRepository.updateValue(mapCategory(root))
                    excursionRepository.updateValue(mapExcursion(root))
                    pathRepository.updateValue(mapPath(root))
                    placeRepository.updateValue(mapPlaces(root))
                }
                .map { true }
    }

    private fun mapCategory(dict: Dict) : List<CategoryEntity> {
        return CategoryEntity.parse(dict.configMap["category"] as Array)
    }

    private fun mapExcursion(dict: Dict) : List<ExcursionEntity> {
        return ExcursionEntity.parse(dict.configMap["excursion"]as Array)
    }

    private fun mapPath(dict: Dict) : List<PathEntity> {
        return PathEntity.parse(dict.configMap["path"]as Array)
    }

    private fun mapPlaces(dict: Dict) : List<PlaceEntity> {
        return PlaceEntity.parse(dict.configMap["places"]as Array)
    }

    private fun toPlist(source: String) : PList {
        val parser = PListXMLParser()
        val handler = PListXMLHandler()
        parser.handler = handler
        parser.parse(source)
        return (parser.handler as PListXMLHandler).plist
    }
}

