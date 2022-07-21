package ru.android.emotionapp

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import ru.android.emotionapp.BuildConfig.DEBUG
import ru.android.emotionapp.databinding.ActivityMainBinding
import ru.android.emotionapp.ui.emotion.EmotionSheetDialogFragment
import ru.android.emotionapp.ui.home.HomeFragment
import ru.android.emotionapp.ui.profile.ProfileFragment
import ru.android.emotionapp.ui.settings.SettingsFragment
import ru.android.emotionapp.ui.statistic.StatisticFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("AAA","Activity create")

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        //val appBarConfiguration = AppBarConfiguration(setOf(
        //        R.id.navigation_home, R.id.navigation_statistics, R.id.navigation_emotion_btn ,R.id.navigation_profile,R.id.navigation_settings))
        //setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)

        val emotionBtn = findViewById<BottomNavigationItemView>(R.id.navigation_emotion_btn)
        emotionBtn.setOnClickListener {
            EmotionSheetDialogFragment().show(supportFragmentManager, "tag")
        }

    }

}