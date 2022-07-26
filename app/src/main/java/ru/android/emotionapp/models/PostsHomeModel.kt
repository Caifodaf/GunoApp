package ru.android.emotionapp.models

data class PostsHomeModel(
    val imageSrcLink:String? = "",
    val timeRead:Int? = 0,
    val favorite:Boolean = false,
    val genre:String = "",
    val title:String = "",
    val srcData:String? = "",
)
