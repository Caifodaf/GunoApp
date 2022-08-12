package ru.android.emotionapp.ui.settings.ui.appearance

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.android.emotionapp.R
import ru.android.emotionapp.ui.home.HomeViewModel

@AndroidEntryPoint
class AppearanceFragment : Fragment() {

    companion object {
        fun newInstance() = AppearanceFragment()
    }

    private val viewModel by viewModels<AppearanceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.appearance_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}