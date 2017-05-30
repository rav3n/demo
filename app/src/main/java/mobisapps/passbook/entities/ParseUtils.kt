package mobisapps.passbook.entities

import com.longevitysoft.android.xml.plist.domain.Integer
import com.longevitysoft.android.xml.plist.domain.Array
import com.longevitysoft.android.xml.plist.domain.String

fun listOfIntByArray(array: Array) : List<Int> {
    val items = arrayListOf<Int>()
    array.forEach{ items.add((it as Integer).value) }
    return items
}

fun listOfStringByArray(array: Array) : List<kotlin.String> {
    val items = arrayListOf<kotlin.String>()
    array.forEach{ items.add((it as String).value) }
    return items
}


