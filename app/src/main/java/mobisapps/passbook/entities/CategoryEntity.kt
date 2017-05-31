package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Dict
import com.longevitysoft.android.xml.plist.domain.False
import com.longevitysoft.android.xml.plist.domain.Array
import com.longevitysoft.android.xml.plist.domain.Integer

class CategoryEntity (
        val id: Int,
        val hidden: Boolean,
        val key: String,
        val name: String,
        val places: List<Int>
) {
    companion object {
        fun parse(array: com.longevitysoft.android.xml.plist.domain.Array) : List<CategoryEntity> {
            val list = arrayListOf<CategoryEntity>()
            array.forEach {
                it as Dict
                list.add(
                        CategoryEntity(
                                (it.configMap["categoryId"] as Integer).value,
                                (it.configMap["categoryHidden"] as False).value,
                                (it.configMap["categoryKey"] as com.longevitysoft.android.xml.plist.domain.String).value,
                                (it.configMap["categoryName"] as com.longevitysoft.android.xml.plist.domain.String).value,
                                listOfIntByArray(it.configMap["categoryPlaces"] as Array)
                        )
                )
            }
            return list
        }
    }
}

