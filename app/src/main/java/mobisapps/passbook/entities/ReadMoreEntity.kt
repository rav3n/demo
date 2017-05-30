package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Dict
import com.longevitysoft.android.xml.plist.domain.String

class ReadMoreEntity(
        val text: kotlin.String,
        val url: kotlin.String
) {
    companion object {
        fun parse(dict: Dict): ReadMoreEntity {
            return ReadMoreEntity(
                    (dict.configMap["text"] as String).value,
                    (dict.configMap["url"] as String).value
            )
        }
    }
}
