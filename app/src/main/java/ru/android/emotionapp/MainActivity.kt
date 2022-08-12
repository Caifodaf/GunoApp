package ru.android.emotionapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import ru.android.emotionapp.databinding.ActivityMainBinding
import ru.android.emotionapp.ui.emotion.EmotionSheetDialogFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("AAA","Activity create")

        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        val emotionBtn = findViewById<BottomNavigationItemView>(R.id.navigation_emotion_btn)
        emotionBtn.setOnClickListener {
            EmotionSheetDialogFragment().show(supportFragmentManager, "tag")
        }



    }

    override fun onStart() {
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.

        //val account = GoogleSignIn.getLastSignedInAccount(this)
        //Log.e("AAA","Activity google - $account")
        //updateUI(account)

        super.onStart()
    }

}