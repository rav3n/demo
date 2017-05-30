package mobisapps.passbook.dagger

import android.content.Context
import com.amurnet.coupon.v2.core.network.Config
import com.amurnet.coupon.v2.core.network.RetrofitBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {

    @Provides fun provideRetrofit(context: Context) : Retrofit {
        return RetrofitBuilder.build(context, Config.serverUrl)
    }

}