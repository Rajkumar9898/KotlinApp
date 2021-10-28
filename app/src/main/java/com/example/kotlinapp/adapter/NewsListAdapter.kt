package com.example.kotlinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.model.Post
import com.example.kotlinapp.R


class NewsListAdapter(private val mList: List<Post>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = mList[position]
        // sets the text to the textview from our itemHolder class
        holder.title_text.text =post.title
        holder.body_text.text = post.body
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title_text: TextView = itemView.findViewById(R.id.tittle_text)
        val body_text: TextView = itemView.findViewById(R.id.body_text)
    }
}


