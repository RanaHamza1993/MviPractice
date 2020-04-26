package com.havelisolutions.mvipractice.repo

import com.havelisolutions.mvipractice.endpoints.Api
import com.havelisolutions.mvipractice.generics.SafeApiRequest
import com.havelisolutions.mvipractice.generics.SafeApiResponse
import com.havelisolutions.mvipractice.models.Post

//Singleton class for making requests and return the data to viewModel
class Repository constructor(
    private val myApi: Api
): SafeApiRequest() {
//    private val totalStatsLiveData:MutableLiveData<SafeApiResponse<List<TotalStats>>>()
    //private val createdDestination=MutableLiveData<Destination>()

    companion object {
        @Volatile
        private var INSTANCE: Repository? = null

        fun getInstance(myApi: Api) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Repository(myApi).also {
                    INSTANCE = it
                }
            }
    }
    //Susped function can suspend and resume any time its is for running in the coroutines so the view will not freeze
    suspend fun getPosts(): SafeApiResponse<List<Post>> {
        //apiSafeRequest is the wrapping of response
        //arrow showing on left is mean it is suspended function or its is coroutine
        return apiSafeRequest{myApi.getPosts()}
    }

}