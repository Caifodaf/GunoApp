package ru.android.emotionapp.ui.settings.ui.language

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
class LanguageFragment : Fragment() {

    companion object {
        fun newInstance() = LanguageFragment()
    }

    private val viewModel by viewModels<LanguageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.language_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(LanguageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}