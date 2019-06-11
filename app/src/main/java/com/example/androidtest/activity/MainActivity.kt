package com.example.androidtest.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.androidtest.R
import com.example.androidtest.adapter.PostsAdapter
import com.example.androidtest.model.BaseResponseBody
import com.example.androidtest.model.Posts
import com.example.androidtest.network.PostsAPI
import com.example.androidtest.network.RequestManager
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private  var listPosts : RecyclerView? = null
    private val models : MutableList<Posts> = ArrayList()
    private var adapter : PostsAdapter? = null
    private var postsApi : PostsAPI? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        getData()
    }

    fun initView(){
        listPosts = findViewById(R.id.list_posts)
        listPosts?.layoutManager = LinearLayoutManager(this)
    }

    fun getData(){
        postsApi = RequestManager().getRequestManager()?.create(PostsAPI::class.java)
        val call : retrofit2.Call<BaseResponseBody>? = postsApi?.getPosts()
        call?.enqueue(object : retrofit2.Callback<BaseResponseBody> {
            override fun onResponse(call: retrofit2.Call<BaseResponseBody>, response: Response<BaseResponseBody>) {
                response.body()?.posts?.let { models.addAll(it) }
                adapter = PostsAdapter(models)
                listPosts?.adapter = adapter
            }

            override fun onFailure(call: retrofit2.Call<BaseResponseBody>?, t: Throwable?) {
                Log.d("TESTING", "error = " + t?.message)
            }
        })
    }
}

