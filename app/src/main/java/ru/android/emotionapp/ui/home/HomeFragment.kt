package ru.android.emotionapp.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.FragmentHomeBinding
import ru.android.emotionapp.data.model.PostsHomeModel
import ru.android.emotionapp.ui.home.adapter.AdapterNewPosts
import ru.android.emotionapp.ui.home.adapter.ViewPagerCollectionAdapter
import ru.android.emotionapp.ui.home.viewpagercontent.ViewPager2ViewHeightAnimator
import ru.android.emotionapp.uitilits.RecyclerViewClickListener
import ru.android.emotionapp.uitilits.SpaceItemDecoration

@AndroidEntryPoint
class HomeFragment : Fragment(), RecyclerViewClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var viewPagerCollectionAdapter: ViewPagerCollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        //homeViewModel =
        //    ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //getApi()
        initNewRecyclerView()
        initViewPager2()

        return root
    }

    private fun getApi(){
        viewModel.getPost("New").observe(viewLifecycleOwner) { post ->
        }
    }

    private fun initNewRecyclerView(){
        if(viewModel.newpost.value.isNullOrEmpty())
            viewModel.getNewPost()

        viewModel.newpost.observe(viewLifecycleOwner, Observer { newpost ->
            binding.rvNewHome.also {
                it.addItemDecoration(SpaceItemDecoration())
                it.adapter = AdapterNewPosts(newpost,this)
            }
        })
    }

    private fun initViewPager2(){
        viewPagerCollectionAdapter = ViewPagerCollectionAdapter(this)
        viewPager = binding.vpMoreContentHome
        viewPager.adapter = viewPagerCollectionAdapter

        binding.tvPager1.setOnClickListener {
            setColorBtn(binding.tvPager1,binding.tvPager2,binding.tvPager3)
            viewPager.currentItem = 0
        }
        binding.tvPager2.setOnClickListener {
            setColorBtn(binding.tvPager2,binding.tvPager1,binding.tvPager3)
            viewPager.currentItem = 1
        }
        binding.tvPager3.setOnClickListener {
            setColorBtn(binding.tvPager3,binding.tvPager1,binding.tvPager2)
            viewPager.currentItem = 2
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                    when(position){
                        0 ->{setColorBtn(
                            binding.tvPager1,binding.tvPager2,binding.tvPager3)
                            viewPagerCollectionAdapter.type = "ALL"}
                        1 ->{setColorBtn(
                            binding.tvPager2,binding.tvPager1,binding.tvPager3)
                            viewPagerCollectionAdapter.type = "READ"}
                        2 ->{setColorBtn(
                            binding.tvPager3,binding.tvPager1,binding.tvPager2)
                            viewPagerCollectionAdapter.type = "RECOMMENDED"}
                    }
            }
        })

        val viewPager2ViewHeightAnimator = ViewPager2ViewHeightAnimator()
        viewPager2ViewHeightAnimator.viewPager2 = viewPager
    }

    private fun setColorBtn(viewSet: TextView, view2: TextView, view3: TextView){
        viewSet.setTextColor(activity?.getColor(R.color.black_03)!!)
        view2.setTextColor(activity?.getColor(R.color.grey_04)!!)
        view3.setTextColor(activity?.getColor(R.color.grey_04)!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("ResourceAsColor")
    override fun onRecyclerViewItemClick(view: View, list: Any?) {
        when (view.id) {
            R.id.iv_favorite -> {
                Toast.makeText(context, "Авторизируйтесь для сохранения", Toast.LENGTH_SHORT).show()
                Log.e("AAA","Frag iv_favorite + ${list}")
                viewModel.saveFavoritePost(view,list as PostsHomeModel)
            }
            R.id.card_base_item -> {
                Log.e("AAA","Frag card_base_item")
            }
        }
    }
}