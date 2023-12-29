package com.example.lessonplan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonplan.model.Post
import com.example.lessonplan.R

class MyAdapter(private val postList:ArrayList<Post>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = postList[position]
        holder.postId.text = currentItem.id.toString()
        holder.postContent.text = currentItem.body
        holder.postTitle.text = currentItem.title
    }

    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val postId : TextView = itemView.findViewById(R.id.textViewPostId)
        val postTitle : TextView = itemView.findViewById(R.id.textViewPostTitle)
        val postContent : TextView = itemView.findViewById(R.id.textViewPostContent)
    }


}