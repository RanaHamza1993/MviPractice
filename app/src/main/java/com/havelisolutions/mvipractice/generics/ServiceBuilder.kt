package com.havelisolutions.mvipractice.generics

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Used for getting the retrofit instance pass the api interface and get its implementation
object ServiceBuilder {
    public const val BASE_URL="https://jsonplaceholder.typicode.com/"
    //public const val BASE_URL="http://api.alquran.cloud/v1/"

    //HttpInteceptor
    private val logger: HttpLoggingInterceptor =HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //create OKhttp Client
    private  val okhttpBuilder: OkHttpClient.Builder =OkHttpClient.Builder().addInterceptor(logger)



    //Create Retrofit Builder

    private val builder: Retrofit.Builder =Retrofit.Builder().
                        baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                        .client(okhttpBuilder.build())

    private val retrofit: Retrofit = builder.build()

    //Generic function for getting the implementation of api interfaces
    operator fun<T> invoke(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }
}