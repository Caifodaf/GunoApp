package ru.android.emotionapp.api.init

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.android.emotionapp.api.ApiService
import ru.android.emotionapp.api.data.MainRemoteData
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl() : String = "https://gime.ru/api/"

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL : String) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideMainService(retrofit : Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideMainRemoteData(mainService : ApiService) : MainRemoteData = MainRemoteData(mainService)
}
