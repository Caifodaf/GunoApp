package ru.android.emotionapp.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.PostItemBinding
import ru.android.emotionapp.data.model.PostsHomeModel
import ru.android.emotionapp.uitilits.RecyclerViewClickListener


class AdapterAllPosts(
    private val itemViewModels: List<PostsHomeModel>,
    private val listenerAllPost: RecyclerViewClickListener
): RecyclerView.Adapter<AdapterAllPosts.ViewHolderAllPosts>() {

    private companion object{
        private const val LIST_ITEM = "objectList"
        private const val ALL_TYPE_LIST = "ALL"
        private const val READ_TYPE_LIST = "READ"
        private const val RECOMMENDED_TYPE_LIST = "RECOMMENDED"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAllPosts =
        ViewHolderAllPosts(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.post_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolderAllPosts, position: Int) {
        holder.recyclerviewAllPostBinding.allPost = itemViewModels[position]
        holder.recyclerviewAllPostBinding.ivFavorite.setOnClickListener {
            listenerAllPost.onRecyclerViewItemClick(holder.recyclerviewAllPostBinding.ivFavorite, itemViewModels[position])
        }
        holder.recyclerviewAllPostBinding.cardBaseItem.setOnClickListener {
            listenerAllPost.onRecyclerViewItemClick(holder.recyclerviewAllPostBinding.cardBaseItem, itemViewModels[position])
        }
        holder.bind()
    }

    override fun getItemCount(): Int = itemViewModels.size

    inner class ViewHolderAllPosts(
        val recyclerviewAllPostBinding: PostItemBinding
    ) : RecyclerView.ViewHolder(recyclerviewAllPostBinding.root){

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(){

            if(!recyclerviewAllPostBinding.allPost?.imageSrcLink.isNullOrEmpty()) {
                Glide.with(itemView.context)
                    .load(recyclerviewAllPostBinding.allPost!!.imageSrcLink)
                    .circleCrop()
                    .placeholder(R.drawable.ic_user_round)
                    .into(recyclerviewAllPostBinding.ivAvatarUserPost)
            }else{
                recyclerviewAllPostBinding.ivAvatarUserPost.setImageDrawable(
                    itemView.context.getDrawable(R.drawable.ic_user_round))
            }
        }
    }
}

