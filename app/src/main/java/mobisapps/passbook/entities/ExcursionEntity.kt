package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.*
import com.longevitysoft.android.xml.plist.domain.Array
import com.longevitysoft.android.xml.plist.domain.String

class ExcursionEntity(
        val id: Int,
        val description: kotlin.String,
        val key: kotlin.String,
        val name: kotlin.String,
        val places: List<Int>,
        val points: List<PointEntity>,
        val readMore: ReadMoreEntity
) {
    companion object {
        fun parse(array: com.longevitysoft.android.xml.plist.domain.Array) : List<ExcursionEntity> {
            val list = arrayListOf<ExcursionEntity>()
            array.forEach {
                it as Dict
                list.add(
                    ExcursionEntity(
                        (it.configMap["excursionId"] as Integer).value,
                        (it.configMap["excursionDescription"] as String).value,
                        (it.configMap["excursionKey"] as String).value,
                        (it.configMap["excursionName"] as String).value,
                        listOfIntByArray(it.configMap["excursionPlaces"] as Array),
                        PointEntity.parse(it.configMap["excursionPoints"] as Array),
                        ReadMoreEntity.parse(it.configMap["excursionReadMore"] as Dict)
                    )
                )
            }
            return list
        }
    }
}

