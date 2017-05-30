package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Array
import com.longevitysoft.android.xml.plist.domain.Dict
import com.longevitysoft.android.xml.plist.domain.Integer
import com.longevitysoft.android.xml.plist.domain.Real

class PlaceEntity(
    val id: Int,
    val address: String,
//        val brand
    val contact: ContactEntity,
    val details: String,
//        val distinct: String
    val extInfo: ExtInfoEntity,
    val info: InfoEntity,
    val lat: Float,
    val lon: Float,
    val metro: MetroEntity,
    val metroDistance: String,
    val name: String,
    val photo: List<String>,
    val photoThumbs: List<String>,
    val priority: Int,
    val rating: Float,
    val readMore: ReadMoreEntity,
    val workTimeInterval: String
) {
    companion object {
        fun parse(array: Array) : List<PlaceEntity> {
            val items = arrayListOf<PlaceEntity>()
            array.forEach{
                it as Dict
                items.add(
                    PlaceEntity (
                        (it.configMap["id"] as Integer).value,
                        (it.configMap["address"] as com.longevitysoft.android.xml.plist.domain.String).value,
                        ContactEntity.parse(it.configMap["contact"] as Dict),
                        (it.configMap["details"] as com.longevitysoft.android.xml.plist.domain.String).value,
                        ExtInfoEntity.parse(it.configMap["ext_info"] as Dict),
                        InfoEntity.parse(it.configMap["info"] as Dict),
                        (it.configMap["lat"] as Real).value,
                        (it.configMap["lon"] as Real).value,
                        MetroEntity.parse(it.configMap["metro"] as Dict),
                        (it.configMap["metro_distance"] as com.longevitysoft.android.xml.plist.domain.String).value,
                        (it.configMap["name"] as com.longevitysoft.android.xml.plist.domain.String).value,
                        listOfStringByArray(it.configMap["photo"] as Array),
                        listOfStringByArray(it.configMap["photo_thumbs"] as Array),
                        (it.configMap["priority"] as Integer).value,
                        (it.configMap["rating"] as Real).value,
                        ReadMoreEntity.parse((it.configMap["read_more"] as Dict)),
                        (it.configMap["worktime_interval"] as com.longevitysoft.android.xml.plist.domain.String).value
                    )
                )
            }
            return items
        }
    }
}
