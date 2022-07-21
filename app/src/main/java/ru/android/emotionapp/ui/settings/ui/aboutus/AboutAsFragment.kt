package ru.android.emotionapp.ui.settings.ui.aboutus

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.android.emotionapp.R

class AboutAsFragment : Fragment() {

    companion object {
        fun newInstance() = AboutAsFragment()
    }

    private lateinit var viewModel: AboutAsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.aboutas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AboutAsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}