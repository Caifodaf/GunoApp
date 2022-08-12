package ru.android.emotionapp.ui.settings.ui.contacts

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.ContactsFragmentBinding
import ru.android.emotionapp.ui.home.HomeViewModel

@AndroidEntryPoint
class ContactsFragment : Fragment() {

    private var _binding: ContactsFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ContactsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel =
        //    ViewModelProvider(this).get(ContactsViewModel::class.java)

        _binding = ContactsFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val textEmail = "<font color=#000000>cmd.type</font> <font color=#B2B2B2>@gmail.com</font>"
        binding.tvGmail.text = Html.fromHtml(textEmail)

        binding.tvSendMessageBtn.setOnClickListener {
            viewModel.btnFromSendMessage()
        }

        binding.llOurBehance.setOnClickListener {
            viewModel.btnFromBehance()
        }

        binding.llOurInstagram.setOnClickListener {
            viewModel.btnFromInstagram()
        }

        binding.llOurTwitter.setOnClickListener {
            viewModel.btnFromTwitter()
        }









        return root
    }

}