package ru.android.emotionapp.api.data

import ru.android.emotionapp.api.ApiService
import javax.inject.Inject

class MainRemoteData @Inject constructor(private val apiService : ApiService) {

    suspend fun getPost(type : String) = apiService.getPosts(type)
}