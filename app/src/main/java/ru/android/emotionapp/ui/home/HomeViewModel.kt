package ru.android.emotionapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.android.emotionapp.api.DataDebug.DataDebug
import ru.android.emotionapp.models.PostsHomeModel
import ru.android.emotionapp.ui.home.adapter.AdapterNewPosts
import ru.android.emotionapp.uitilits.SpaceItemDecoration

class HomeViewModel : ViewModel() {

    private val dataDebug = DataDebug()
    private val list = mutableListOf<PostsHomeModel>()

    private var listNewCreated = false
    private var listStringCreated = false
    private var listVPCreated = false

    init {
        Log.e("AAA","VM create")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun initRecyclerView(rvNew: RecyclerView,rvString: RecyclerView,rvViewPager2: RecyclerView){
        initRecyclerViewNewList(rvNew)
        initRecyclerViewStringPages(rvString)
        initRecyclerViewViewPager2(rvViewPager2)
    }

    fun initRecyclerViewNewList(recyclerView: RecyclerView){
        val adapterNewPosts = AdapterNewPosts()

        recyclerView.addItemDecoration(SpaceItemDecoration())
        recyclerView.adapter = adapterNewPosts

        if (listNewCreated)
            adapterNewPosts.setMain(dataDebug.setNewHome(list))

        listNewCreated = true
    }

    fun clearRecyclerViewNewList(adapter: AdapterNewPosts,){
        adapter.setClear()
    }

    fun initRecyclerViewStringPages(recyclerView: RecyclerView){
        val adapterNewPosts = AdapterNewPosts()

        recyclerView.addItemDecoration(SpaceItemDecoration())
        recyclerView.adapter = adapterNewPosts

        if (listStringCreated)
            adapterNewPosts.setMain(dataDebug.setNewHome(list))

        listStringCreated = true
    }

    fun initRecyclerViewViewPager2(recyclerView: RecyclerView){
        val adapterNewPosts = AdapterNewPosts()

        recyclerView.addItemDecoration(SpaceItemDecoration())
        recyclerView.adapter = adapterNewPosts

        if (listVPCreated)
            adapterNewPosts.setMain(dataDebug.setNewHome(list))

        listVPCreated = true
    }

    fun clearRecyclerViewViewPager2(adapter: AdapterNewPosts,){
        adapter.setClear()
    }



    override fun onCleared() {
        Log.e("AAA","VM clear")
        super.onCleared()
    }
}