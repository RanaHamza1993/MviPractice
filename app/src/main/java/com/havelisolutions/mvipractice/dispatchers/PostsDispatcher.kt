package com.havelisolutions.mvipractice.dispatchers

import androidx.lifecycle.liveData
import com.havelisolutions.mvipractice.actions.PostActions
import com.havelisolutions.mvipractice.generics.SafeApiResponse
import com.havelisolutions.mvipractice.intefaces.Action
import com.havelisolutions.mvipractice.models.Post
import com.havelisolutions.mvipractice.repo.Repository

class PostsDispatcher(private val repo: Repository) {

    fun dispatchAction(action: Action) = liveData {
        when (action) {
            is PostActions.getPostAction -> {
                emit(SafeApiResponse.Loading(null))
                emit(getPosts())
            }
        }
    }

    private suspend fun getPosts():SafeApiResponse<List<Post>>{
        return when(val response: SafeApiResponse<List<Post>> =repo.getPosts()){
            is SafeApiResponse.Loading ->{
                SafeApiResponse.Loading(null)
            }
            is SafeApiResponse.Success ->{
                SafeApiResponse.Success(response.data,200)
            }
            is SafeApiResponse.Error ->{
                SafeApiResponse.Error(null,response.message,response.statusCode)

            }
        }
    }
}