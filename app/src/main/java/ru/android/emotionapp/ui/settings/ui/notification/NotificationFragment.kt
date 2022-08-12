package ru.android.emotionapp.ui.settings.ui.notification

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
class NotificationFragment : Fragment() {

    companion object {
        fun newInstance() = NotificationFragment()
    }

    private val viewModel by viewModels<NotificationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notification_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}