package ru.android.emotionapp.data.model

data class PostsHomeModel(
    val id:Int? = 0,
    val imageSrcLink:String? = "",
    val timeRead:String? = "1",
    val favorite:Boolean = false,
    val genre:String = "",
    val title:String = "",
    val srcData:String? = "",
)
