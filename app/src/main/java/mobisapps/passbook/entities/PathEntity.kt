package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Array
import com.longevitysoft.android.xml.plist.domain.Dict
import com.longevitysoft.android.xml.plist.domain.Integer
import com.longevitysoft.android.xml.plist.domain.String

class PathEntity(
    val id: Int,
    val descrition: kotlin.String,
    val key: kotlin.String,
    val name: kotlin.String,
    val places: List<Int>,
    val points: List<PointEntity>,
    val readMore: ReadMoreEntity
) {
    companion object {
        fun parse(array: Array): List<PathEntity> {
            val list = arrayListOf<PathEntity>()
            array.forEach {
                it as Dict
                list.add(
                    PathEntity(
                        (it.configMap["pathId"] as Integer).value,
                        (it.configMap["pathDescription"] as String).value,
                        (it.configMap["pathKey"] as String).value,
                        (it.configMap["pathName"] as String).value,
                        listOfIntByArray((it.configMap["pathPlaces"] as Array)),
                        PointEntity.parse((it.configMap["pathPoints"] as Array)),
                        ReadMoreEntity.parse((it.configMap["pathReadMore"] as Dict))
                    )
                )
            }
            return list
        }
    }
}
