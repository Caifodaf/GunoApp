package ru.android.emotionapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var settingsViewModel: SettingsViewModel

    private lateinit var accountBtn: RelativeLayout

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        settingsViewModel =
                ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textSettings
//        settingsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        unitBtnSettings()

        return root
    }

    private fun unitBtnSettings(){
        val accountBtn = binding.llAccountBtn
        val notificationBtn = binding.llNotificationBtn
        val langBtn = binding.llLanguageBtn
        val aboutUsBtn = binding.llAboutAsBtn
        val appearanceBtn = binding.llAppearanceBtn
        val contactsBtn = binding.llContactsBtn

        accountBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_account)
        }
        notificationBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_notification)
        }
        langBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_language)
        }
        aboutUsBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_aboutAs)
        }
        appearanceBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_appearance)
        }
        contactsBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_contacts)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}