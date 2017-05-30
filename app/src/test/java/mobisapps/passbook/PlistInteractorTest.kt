package mobisapps.passbook

import android.util.Log
import mobisapps.passbook.plist.PlistInteractor
import mobisapps.passbook.plist.PlistProvider
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import rx.Observable
import rx.observers.TestSubscriber

@RunWith(value = PowerMockRunner::class)
@PrepareForTest(value = Log::class)
class PlistInteractorTest {

    var source: String = ""
    val provider = Mockito.mock(PlistProvider::class.java)!!

    @Before
    fun setUp() {
        PowerMockito.mockStatic(Log::class.java)
        Mockito.`when`(provider.getPlist()).thenReturn(Observable.just(source))
    }

    @Test
    fun provideTest() {
        val testSubscriber = TestSubscriber.create<String>()
        provider.getPlist().subscribe(testSubscriber)
        testSubscriber.assertValue(source)
    }
}