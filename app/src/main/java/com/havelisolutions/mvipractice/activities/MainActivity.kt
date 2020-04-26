package com.havelisolutions.mvipractice.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.havelisolutions.mvipractice.R
import com.havelisolutions.mvipractice.adapters.PostAdapter
import com.havelisolutions.mvipractice.databinding.MainActivityBinding
import com.havelisolutions.mvipractice.dispatchers.PostsDispatcher
import com.havelisolutions.mvipractice.endpoints.Api
import com.havelisolutions.mvipractice.extensions.isVisible
import com.havelisolutions.mvipractice.generics.ServiceBuilder
import com.havelisolutions.mvipractice.models.Post
import com.havelisolutions.mvipractice.repo.Repository
import com.havelisolutions.mvipractice.responses.PostViewState
import com.havelisolutions.mvipractice.viewmodels.PostsViewModel
import com.havelisolutions.mvipractice.viewmodels.ViewModelsFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModelFactory:ViewModelsFactory
    private lateinit var viewModel:PostsViewModel
    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory= ViewModelsFactory(
            PostsDispatcher(Repository(ServiceBuilder(Api::class.java)))
        )
        viewModel=ViewModelProvider(this,viewModelFactory).get(PostsViewModel::class.java)

        viewModel.postsViewStatsLiveData.observe(this, Observer {
            render(it)
        })
    }

    private fun setAdapter(posts: List<Post>?) {
        binding.postsRecycler.also {
            it.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
            it.adapter = PostAdapter(posts)
        }


    }
    private fun render(it:PostViewState){
        binding.progressBar.isVisible = it.isLoading
        setAdapter(it.posts)
    }
}
