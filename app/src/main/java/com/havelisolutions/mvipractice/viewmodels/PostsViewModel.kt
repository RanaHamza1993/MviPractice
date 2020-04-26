package com.havelisolutions.mvipractice.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.havelisolutions.mvipractice.actions.PostActions
import com.havelisolutions.mvipractice.dispatchers.PostsDispatcher
import com.havelisolutions.mvipractice.generics.SafeApiResponse
import com.havelisolutions.mvipractice.repo.Repository
import com.havelisolutions.mvipractice.responses.PostViewState

class PostsViewModel (dispatcher: PostsDispatcher):ViewModel(){
    private val postsViewState=PostViewState()
    val postsViewStatsLiveData:LiveData<PostViewState> =
    Transformations.map(dispatcher.dispatchAction(PostActions.getPostAction)){
        when(it){
            is SafeApiResponse.Loading ->{
                postsViewState.copy(isLoading = true)
            }
            is SafeApiResponse.Success ->{
                postsViewState.copy(posts = it.data!!)
            }
            is SafeApiResponse.Error ->{
                postsViewState.copy(error=it.message)
            }
        }
    }
}