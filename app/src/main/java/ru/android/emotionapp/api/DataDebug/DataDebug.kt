package ru.android.emotionapp.api.DataDebug

import ru.android.emotionapp.data.model.PostsHomeModel

class DataDebug {

    fun setNewHome(list: MutableList<PostsHomeModel>): MutableList<PostsHomeModel> {
        val image = "https://sun1.userapi.com/sun1-28/s/v1/ig2/lQ2-FOi4O0hZ6Mpt1smwjQ_HWe-70Fs-Lzv0f-aNMoH5dz9-KO7dIfo5JrsnmUnzttk9_3WTdHNbKnmP8er1F_wI.jpg?size=1280x853&quality=96&type=album"

        list.add(
            PostsHomeModel(
                id = 1,
                imageSrcLink = image,
                timeRead = "46 минут",
                favorite = false,
                genre = "Творчество",
                title = "Как выйти из кризиса идей если всё совсем плохо?",
                srcData = null
            )
        )

        list.add(
            PostsHomeModel(
                id = 2,
                imageSrcLink = null,
                timeRead = "7 минут",
                favorite = false,
                genre = "Романтика",
                title = "Как выйти из кризиса идей если всё совсем плохо?",
                srcData = null
            )
        )

        list.add(
            PostsHomeModel(
                id = 3,
                imageSrcLink = null,
                timeRead = "Болле часа",
                favorite = false,
                genre = "Любовь",
                title = "Как выйти из кризиса идей если всё совсем плохо?",
                srcData = null
            )
        )

        return list
    }
}