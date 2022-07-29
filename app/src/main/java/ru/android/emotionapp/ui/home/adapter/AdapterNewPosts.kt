package ru.android.emotionapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.PostItemSmallBinding
import ru.android.emotionapp.data.model.PostsHomeModel
import ru.android.emotionapp.uitilits.RecyclerViewClickListener


class AdapterNewPosts(
    private val itemViewModels: List<PostsHomeModel>,
    private val listenerNewPost: RecyclerViewClickListener
): RecyclerView.Adapter<AdapterNewPosts.ViewHolderNewPosts>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNewPosts =
        ViewHolderNewPosts(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.post_item_small,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolderNewPosts, position: Int) {
        holder.recyclerviewNewPostBinding.newpost = itemViewModels[position]
        holder.recyclerviewNewPostBinding.ivFavorite.setOnClickListener {
            listenerNewPost.onRecyclerViewItemClick(holder.recyclerviewNewPostBinding.ivFavorite, itemViewModels[position])
        }
        holder.recyclerviewNewPostBinding.cardBaseItem.setOnClickListener {
            listenerNewPost.onRecyclerViewItemClick(holder.recyclerviewNewPostBinding.cardBaseItem, itemViewModels[position])
        }
        holder.bind()
    }

    override fun getItemCount(): Int = itemViewModels.size

    inner class ViewHolderNewPosts(
        val recyclerviewNewPostBinding: PostItemSmallBinding
    ) : RecyclerView.ViewHolder(recyclerviewNewPostBinding.root){

        fun bind(){

            if(!recyclerviewNewPostBinding.newpost?.imageSrcLink.isNullOrEmpty()) {
                Glide.with(itemView.context)
                    .load(recyclerviewNewPostBinding.newpost!!.imageSrcLink)
                    .circleCrop()
                    .placeholder(R.drawable.ic_user_round)
                    .into(recyclerviewNewPostBinding.ivAvatarUserPost)
            }else{
                recyclerviewNewPostBinding.ivAvatarUserPost.setImageDrawable(
                    itemView.context.getDrawable(R.drawable.ic_user_round))
            }
        }
    }
}


