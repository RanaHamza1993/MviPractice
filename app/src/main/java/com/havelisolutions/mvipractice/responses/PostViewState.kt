package com.havelisolutions.mvipractice.responses

import com.google.gson.annotations.SerializedName
import com.havelisolutions.mvipractice.intefaces.ViewState
import com.havelisolutions.mvipractice.models.Post

data class PostViewState(
    val isLoading: Boolean = false,
    @SerializedName("results")
    val posts: List<Post> = emptyList(),
    val error: String? = null
) : ViewState