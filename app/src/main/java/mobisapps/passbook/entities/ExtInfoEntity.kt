package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Dict

class ExtInfoEntity(
    val contactName: String,
//    val creditCard: String,
    val kitchen: String
) {

    companion object {
        fun parse(dict: Dict) : ExtInfoEntity {
            return ExtInfoEntity(
                (dict.configMap["contact_name"] as com.longevitysoft.android.xml.plist.domain.String).value,
                (dict.configMap["kitchen"] as com.longevitysoft.android.xml.plist.domain.String).value
            )
        }
    }
}
