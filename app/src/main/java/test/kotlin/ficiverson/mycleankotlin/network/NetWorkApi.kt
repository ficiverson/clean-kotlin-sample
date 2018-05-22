package test.kotlin.ficiverson.mycleankotlin.network

import android.net.Uri
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class NetWorkApi(private val baseUrl: String) {

    companion object {
        private const val OK_HTTP_TIMEOUT = 30L
    }

    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
    }

    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {

            val uriUrl = Uri.parse(baseUrl)

            //add interceptors

            connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)

        }.build()
    }
}