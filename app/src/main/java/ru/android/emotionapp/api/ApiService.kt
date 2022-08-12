package ru.android.emotionapp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.android.emotionapp.data.model.ResponseModelGetPost

interface ApiService {

    @GET("data/post")
    @Headers("Content-Type: application/json")
    suspend fun getPosts(@Path("type") type:String): Response<ResponseModelGetPost>
}