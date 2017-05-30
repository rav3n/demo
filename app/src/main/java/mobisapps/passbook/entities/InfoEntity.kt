package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Dict

class InfoEntity(val howFind: String) {
    companion object {
        fun parse(dict: Dict) : InfoEntity {
            return InfoEntity((dict.configMap["how_find"] as com.longevitysoft.android.xml.plist.domain.String).value)
        }
    }
}