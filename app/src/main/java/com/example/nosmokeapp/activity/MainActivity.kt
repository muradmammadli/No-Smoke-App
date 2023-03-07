package com.example.nosmokeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.nosmokeapp.R
import com.example.nosmokeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setNavHostFragment()
        setContentView(binding.root)
    }

    private fun setNavHostFragment() {
        binding.toolbar.setTitleTextColor(getColor(R.color.white))
        binding.toolbar.title = "İrəliləyiş"
        val navhostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navhostFragment.navController
        binding.bottomNavigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.trophiesFragment->{
                    binding.toolbar.title = "Kuboklar"
                    true
                }
                R.id.healthFragment->{
                    binding.toolbar.title = "Sağlamlıq"
                    true
                }
                R.id.progressFragment->{
                    binding.toolbar.title = "İrəliləyiş"
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigationView.setupWithNavController(navController)
    }


}