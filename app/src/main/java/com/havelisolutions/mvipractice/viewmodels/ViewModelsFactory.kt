package com.havelisolutions.mvipractice.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.havelisolutions.mvipractice.dispatchers.PostsDispatcher
import com.havelisolutions.mvipractice.repo.Repository

@Suppress("UNCHECKED_CAST")

//By default viewmodel constructor can not take parameters so we need viewmodel factory for it
class ViewModelsFactory(
    private val dispatcher: PostsDispatcher
)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(dispatcher) as T
    }
}