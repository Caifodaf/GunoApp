package ru.android.emotionapp.ui.home.viewpagercontent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.FragmentAllViewpagerBinding
import ru.android.emotionapp.data.model.PostsHomeModel
import ru.android.emotionapp.ui.home.HomeViewModel
import ru.android.emotionapp.ui.home.adapter.AdapterAllPosts
import ru.android.emotionapp.uitilits.RecyclerViewClickListener


class AllViewPagerFragment() : Fragment(), RecyclerViewClickListener {

    private companion object{
        private const val LIST_ITEM = "objectList"
        private const val LIST_ITEM_TYPE = "objectType"
    }

    private var _binding: FragmentAllViewpagerBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    private var typeList: String = "ALL"
    private var posList: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllViewpagerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        arguments?.takeIf { it.containsKey(LIST_ITEM) }?.apply {
            posList = getInt(LIST_ITEM)
        }
        arguments?.takeIf { it.containsKey(LIST_ITEM_TYPE) }?.apply {
            typeList = getString(LIST_ITEM_TYPE).toString()
        }

        Log.e("AAA","Frag ${homeViewModel.allPost.value}")
        if(homeViewModel.allPost.value.isNullOrEmpty())
            homeViewModel.getAllPost(posList)


        homeViewModel.allPost.observe(viewLifecycleOwner, Observer { allPost ->
            binding.rvMoreContent.also {
                it.adapter = AdapterAllPosts(allPost,this)
            }
        })
        return root
    }

    override fun onRecyclerViewItemClick(view: View, list: Any?) {
        when (view.id) {
            R.id.iv_favorite -> {
                Toast.makeText(context, "Авторизируйтесь для сохранения", Toast.LENGTH_SHORT).show()
                Log.e("AAA","Frag iv_favorite + ${list}")
                homeViewModel.saveFavoritePost(view,list as PostsHomeModel)
            }
            R.id.card_base_item -> {
                Log.e("AAA","Frag card_base_item")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.root.requestLayout()
    }


}