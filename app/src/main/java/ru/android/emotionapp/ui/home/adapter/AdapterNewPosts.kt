package ru.android.emotionapp.ui.home.adapter

import android.annotation.SuppressLint
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.android.emotionapp.R
import ru.android.emotionapp.models.PostsHomeModel


class AdapterNewPosts: RecyclerView.Adapter<ViewHolderNewPosts>() {
    private var dataSetRec = mutableListOf<PostsHomeModel>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolderNewPosts {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.post_item_small, viewGroup, false)
        return ViewHolderNewPosts(view)
    }

    override fun onBindViewHolder(holder: ViewHolderNewPosts, position: Int) {
        Log.d("ListT", "Load in bind holder - ${dataSetRec.size}")
        holder.bind(dataSetRec[position])
    }

    override fun getItemCount(): Int { return dataSetRec.size }

    fun setMain(list: MutableList<PostsHomeModel>) {
        dataSetRec.clear()
        dataSetRec.addAll(list)
        notifyDataSetChanged()
    }

    fun setClear() {
        dataSetRec.clear()
        notifyDataSetChanged()
    }

}

class ViewHolderNewPosts(private val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var itemAvatarImage: ImageView
    private lateinit var itemDateRead: TextView
    private lateinit var itemFavorite: ImageView
    private lateinit var itemGenre: TextView
    private lateinit var itemTitle: TextView

    @SuppressLint("CheckResult")
    fun bind (dataSet : PostsHomeModel) {
        Log.d("ListT", "Load in bind holder - $dataSet")

        itemAvatarImage = view.findViewById(R.id.iv_avatar_user_post)
        itemDateRead = view.findViewById(R.id.tv_time_created_post)
        itemFavorite = view.findViewById(R.id.iv_favorite)
        itemGenre = view.findViewById(R.id.tv_genres_post)
        itemTitle = view.findViewById(R.id.tv_title_post)

        itemDateRead.text = when(dataSet.timeRead){
            in 1..59 -> "${dataSet.timeRead} ${(itemView.context.getString(R.string.minuts))}"
            else -> itemView.context.getString(R.string.more_hours)
        }

        // Todo Add favorite
        //itemFavorite

        itemGenre.text = dataSet.genre
        itemTitle.text = dataSet.title

        Glide.with(itemView.context)
            .load(dataSet.imageSrcLink)
            .circleCrop()
            .placeholder(R.drawable.ic_user_round)
            .into(itemAvatarImage)

    }
}
