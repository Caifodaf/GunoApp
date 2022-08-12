package ru.android.emotionapp.api

import ru.android.emotionapp.api.data.MainRemoteData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(
    private val remoteData : MainRemoteData
) {

    suspend fun getPost(type : String) = remoteData.getPost(type)
}