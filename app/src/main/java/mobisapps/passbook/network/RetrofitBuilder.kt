package com.amurnet.coupon.v2.core.network

import android.content.Context

import mobisapps.passbook.network.RxErrorHandlingCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitBuilder {

    val ENABLE_LOG = true

    fun build(context: Context, baseUrl: String): Retrofit {
        val clientBuilder = OkHttpClient.Builder()

        if (ENABLE_LOG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(logging)
        }

//        clientBuilder.addInterceptor {
//            val builder = it.request().newBuilder()
//            builder.addHeader("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwaG9uZSI6Iis3OTE0NjAzOTUwNSIsIl9pZCI6IjU4ZmZmOTU3YWMxM2E3NWMyMzMwYjdhYiIsInByb2Zlc3Npb25hbCI6ZmFsc2UsImlhdCI6MTQ5MzE3MDU3MCwiZXhwIjoxNDk1NzYyNTcwfQ.jQxJnSf2Yd_E1QrwaVBsWLijE04uaE2yKQbj3ypOfA8")
//            return@addInterceptor it.proceed(builder.build())
//        }
//        clientBuilder.addInterceptor(ReceivedCookiesInterceptor(cookieHelper))
//        clientBuilder.addInterceptor { chain ->
//            val original = chain.request()
//            val request = original.newBuilder()
//                    .header("showContent-Type", "application/json; charset=utf-8")
//                    .build()
//            val response = chain.proceed(request)
//            response
//        }

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(clientBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create(context))
                .build()

        return retrofit
    }
}
