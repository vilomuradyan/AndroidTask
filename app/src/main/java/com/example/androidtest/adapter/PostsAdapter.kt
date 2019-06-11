package com.example.androidtest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.androidtest.R
import com.example.androidtest.model.Posts
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class PostsAdapter(private val models: List<Posts>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(pareent: ViewGroup, p1: Int): PostsViewHolder {
       return PostsViewHolder(LayoutInflater.from(pareent.context).inflate(R.layout.item_posts, pareent, false))
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.textProfileName?.text = models[position].user_name
        holder.textDate?.text = models[position].date
        holder.textMessage?.text = models[position].message
        Picasso.get().load(models[position].user_pic).into(holder.imageProfile)
        Picasso.get().load(models[position].photo).into(holder.imagePosts)
    }

    class PostsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textProfileName = v.findViewById<TextView>(R.id.text_profile_name)
        val textMessage = v.findViewById<TextView>(R.id.text_message)
        val textDate = v.findViewById<TextView>(R.id.text_date)
        val imageProfile = v.findViewById<CircleImageView>(R.id.image_profile)
        val imagePosts = v.findViewById<ImageView>(R.id.image_posts)

    }
}