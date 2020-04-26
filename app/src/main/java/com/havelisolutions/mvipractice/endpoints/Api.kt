package com.havelisolutions.mvipractice.endpoints

import com.havelisolutions.mvipractice.models.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {


    //Susped function can suspend and resume any time its is for running in the coroutines so the view will not freeze
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>



}