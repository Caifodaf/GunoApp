package ru.android.emotionapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.android.emotionapp.databinding.ActivityMainBinding
import ru.android.emotionapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var splashViewModel: ActivitySplashScreenBinding

    private var splashScreenDuration = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        Log.e("AAA","Activity SplashScreenActivity create")

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, splashScreenDuration.toLong())

    }
}