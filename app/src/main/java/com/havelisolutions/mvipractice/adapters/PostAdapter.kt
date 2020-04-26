package com.havelisolutions.mvipractice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.havelisolutions.mvipractice.R
import com.havelisolutions.mvipractice.databinding.PostItemBinding
import com.havelisolutions.mvipractice.models.Post


class PostAdapter(val posts:List<Post>?): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val postBinding= DataBindingUtil.inflate<PostItemBinding>(
            LayoutInflater.from(parent.context), R.layout.layout_post_list_item,parent,false)

        //returning binding object of postitem
        return PostViewHolder(postBinding)
    }

    override fun getItemCount(): Int {
        //return 0 if post ==null else post.size
       return posts?.size?:0
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        //Now we can access any id from post using postbinding
        holder.setData(position)
    }
    inner class PostViewHolder(private val recyclerViewBinding: PostItemBinding) :
        RecyclerView.ViewHolder(recyclerViewBinding.root) {

         fun setData(position: Int) {
             // accesscing fields directly but i will work with data binding not this
//             recyclerViewBinding.title
             //set post variable in xml using databinding
             //only need this line all other work is in the xml
             recyclerViewBinding.post= posts?.get(position) ?: Post()
        }

    }
}