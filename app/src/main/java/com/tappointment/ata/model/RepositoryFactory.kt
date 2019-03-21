package com.tappointment.ata.model

import android.content.Context
import com.tappointment.ata.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import okhttp3.Headers
import okhttp3.Interceptor
import java.util.concurrent.TimeUnit


object RepositoryFactory {

    private lateinit var baseUrlValue: String
    private lateinit var retrofit: Retrofit
    private lateinit var apiDefinition: APIDefinition
    private lateinit var repository: Repository

    fun init(context: Context) {
        baseUrlValue = context.getString(R.string.base_url_value)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptorForHeaders = createHeadersInterceptor()

        val client = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptorForHeaders)
            .addInterceptor(interceptor)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrlValue)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()


        apiDefinition = retrofit.create(APIDefinition::class.java)
        repository = Repository(apiDefinition)
    }

    private fun createHeadersInterceptor(): Interceptor {
        return Interceptor { chain ->
            //interceptor for headers
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.headers(Headers.Builder()
                    .add("Content-Type", "multipart/form-data")
                    .build())
            chain.proceed(requestBuilder.build())
        }
    }

    fun getRepository(): Repository = repository
}