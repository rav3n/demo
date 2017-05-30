package mobisapps.passbook.plist

import retrofit2.http.GET
import rx.Observable

interface PlistProvider {
    @GET("api/ru/points/plist/")
    fun getPlist() : Observable<String>
}