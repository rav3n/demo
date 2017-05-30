package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Dict

class MetroEntity(
    val lat: String,
    val lon: String,
    val name: String
) {
    companion object {
        fun parse(dict: Dict) : MetroEntity {
            return MetroEntity(
                (dict.configMap["lat"] as com.longevitysoft.android.xml.plist.domain.String).value,
                (dict.configMap["lon"] as com.longevitysoft.android.xml.plist.domain.String).value,
                (dict.configMap["name"] as com.longevitysoft.android.xml.plist.domain.String).value
            )
        }
    }
}