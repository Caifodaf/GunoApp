package ru.android.emotionapp.ui.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import ru.android.emotionapp.api.DataDebug.DataDebug
import ru.android.emotionapp.data.model.PostsHomeModel
import ru.android.emotionapp.uitilits.Coroutines

class HomeViewModel : ViewModel() {

    companion object {
        const val FAVORITE_IS_SAVE = true
        const val FAVORITE_NONE = false
//        const val ALL_TYPE_LIST = "ALL"
//        const val READ_TYPE_LIST = "READ"
//        const val RECOMMENDED_TYPE_LIST = "RECOMMENDED"
        const val ALL_TYPE_LIST = 0
        const val READ_TYPE_LIST = 1
        const val RECOMMENDED_TYPE_LIST = 2
    }

    private val dataDebug = DataDebug()
    private val list = mutableListOf<PostsHomeModel>()
    private lateinit var job: Job

    init {
        Log.e("AAA","VM HomeViewModel create")
    }

//    val onCreateRecyclerView: MutableLiveData<Boolean> by lazy {
//        MutableLiveData<Boolean>()
//    }

    private val _newPost = MutableLiveData<List<PostsHomeModel>>()
    val newpost: LiveData<List<PostsHomeModel>>
        get() = _newPost

    private val _allPost = MutableLiveData<List<PostsHomeModel>>()
    val allPost: LiveData<List<PostsHomeModel>>
        get() = _allPost

    fun getNewPost() {
        job = Coroutines.ioThenMain(
            { dataDebug.setNewHome(list) },
            { _newPost.value = list}
        )
    }

    fun getAllPost(typeList: Int) {
         list.clear()
        when(typeList){
            ALL_TYPE_LIST->{
                job = Coroutines.ioThenMain(
                    { dataDebug.setNewHome(list) },
                    { if(_allPost.value.isNullOrEmpty())
                            _allPost.value = list }
                )}
            READ_TYPE_LIST->{
                job = Coroutines.ioThenMain(
                    { dataDebug.setNewHome(list) },
                    { _allPost.value = listOf(list[0]) }
                )}
            RECOMMENDED_TYPE_LIST->{
                job = Coroutines.ioThenMain(
                    { dataDebug.setNewHome(list) },
                    { _allPost.value = list.reversed() }
                )}
            else->{
                job = Coroutines.ioThenMain(
                    { dataDebug.setNewHome(list) },
                    { _allPost.value = list }
                )
            }
        }

    }

    override fun onCleared() {
        Log.e("AAA","VM clear")
        if(::job.isInitialized) job.cancel()
        super.onCleared()
    }

    @SuppressLint("ResourceAsColor")
    fun saveFavoritePost(view: View, list: PostsHomeModel) {
// TODO add function
        when(list.favorite){
            FAVORITE_NONE->{
            }
            FAVORITE_IS_SAVE->{

            }
        }
    }
}