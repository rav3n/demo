package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Array
import com.longevitysoft.android.xml.plist.domain.Dict
import com.longevitysoft.android.xml.plist.domain.Real
import com.longevitysoft.android.xml.plist.domain.String

class PointEntity(
        val alt: kotlin.String,
        val lat: Float,
        val lon: Float

) {
    companion object {
        fun parse(array: Array): List<PointEntity> {
            val list = arrayListOf<PointEntity>()
            array.forEach {
                it as Dict
                list.add(
                        PointEntity(
                                (it.configMap["alt"] as String).value,
                                (it.configMap["lat"] as Real).value,
                                (it.configMap["lon"] as Real).value
                        )
                )
            }
            return list
        }
    }
}

