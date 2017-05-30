package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Dict

class ContactEntity(
    val email: String,
    val phone: String,
    val phoneComment: String,
    val site: String
) {
    companion object {
        fun parse(dict: Dict) : ContactEntity {
            return ContactEntity(
                (dict.configMap["email"] as com.longevitysoft.android.xml.plist.domain.String).value,
                (dict.configMap["phone"] as com.longevitysoft.android.xml.plist.domain.String).value,
                (dict.configMap["phone_comment"] as com.longevitysoft.android.xml.plist.domain.String).value,
                (dict.configMap["site"] as com.longevitysoft.android.xml.plist.domain.String).value
            )
        }
    }
}
