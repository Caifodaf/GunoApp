package ru.android.emotionapp.ui.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.android.emotionapp.ui.home.HomeViewModel
import ru.android.emotionapp.ui.home.viewpagercontent.AllViewPagerFragment

class ViewPagerCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private companion object{
        private const val LIST_ITEM = "objectList"
        private const val LIST_ITEM_TYPE = "objectType"
    }

    var type = "ALL"

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = AllViewPagerFragment()
        fragment.arguments = Bundle().apply {
            putInt(LIST_ITEM, position)
            putString(LIST_ITEM_TYPE, type)
        }
        return fragment
    }
}