package ru.android.emotionapp.ui.settings

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import dagger.hilt.android.AndroidEntryPoint
import ru.android.emotionapp.R
import ru.android.emotionapp.api.goolgeauth.GoogleAuthorisation
import ru.android.emotionapp.databinding.FragmentSettingsBinding
import ru.android.emotionapp.ui.home.HomeViewModel

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SettingsViewModel>()

    private lateinit var accountBtn: RelativeLayout

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        //settingsViewModel =
        //        ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val google = GoogleAuthorisation()





        val btnLogin = binding.tvLoginDebug
            btnLogin.setOnClickListener(){
                google.signIn(requireActivity())
            }

        unitBtnSettings()

        return root
    }


    private fun unitBtnSettings(){
        binding.llAccountBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_account)
        }
        binding.llNotificationBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_notification)
        }
        binding.llLanguageBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_language)
        }
        binding.llAboutAsBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_aboutAs)
        }
        binding.llAppearanceBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_appearance)
        }
        binding.llContactsBtn.setOnClickListener(){
            findNavController().navigate(R.id.navigation_settings_contacts)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}