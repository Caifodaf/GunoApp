package ru.android.emotionapp.api.DataDebug

import ru.android.emotionapp.databinding.PostItemBinding
import ru.android.emotionapp.models.PostsHomeModel

class DataDebug {

    fun setNewHome(list: MutableList<PostsHomeModel>): MutableList<PostsHomeModel> {
        val image = "https://sun9-29.userapi.com/impg/FdW4mJeREcRy86EbYgS--gh4yAFlQr6c7R6vOQ/Y0TnMsalbBo.jpg?size=1280x720&quality=96&sign=5b452d92355534b0368ae2b0feafcbb6&type=album"

        list.add(
            PostsHomeModel(
                imageSrcLink = image,
                timeRead = 46,
                favorite = false,
                genre = "Творчество",
                title = "Как выйти из кризиса идей если всё совсем плохо?",
                srcData = null
            )
        )

        list.add(
            PostsHomeModel(
                imageSrcLink = null,
                timeRead = 7,
                favorite = false,
                genre = "Романтика",
                title = "Как выйти из кризиса идей если всё совсем плохо?",
                srcData = null
            )
        )

        list.add(
            PostsHomeModel(
                imageSrcLink = null,
                timeRead = 26,
                favorite = false,
                genre = "Любовь",
                title = "Как выйти из кризиса идей если всё совсем плохо?",
                srcData = null
            )
        )

        return list
    }
}