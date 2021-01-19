package com.example.IGClone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.IGClone.DetailPostFragment
import com.example.IGClone.R
import com.example.IGClone.model.Post

class MyImagesAdapter(private val mContext: Context, private val mPost : List<Post>)
    : RecyclerView.Adapter<MyImagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyImagesViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.images_list_item_layout,parent,false)
        return MyImagesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mPost.size
    }

    override fun onBindViewHolder(holder: MyImagesViewHolder, position: Int) {
        val mPost = mPost[position]

        holder.itemView.setOnClickListener {
            val postDetail = mContext.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit()
            postDetail.putString("postId", mPost.getPostId())
            postDetail.apply()

            (mContext as FragmentActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.frag_container, DetailPostFragment()).commit()
        }

        Glide.with(mContext).load(mPost.getPostImage()).into(holder.postImageGrid)



    }
}

class MyImagesViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    var postImageGrid : ImageView = itemView.findViewById(R.id.post_image_grid_profile)
}
