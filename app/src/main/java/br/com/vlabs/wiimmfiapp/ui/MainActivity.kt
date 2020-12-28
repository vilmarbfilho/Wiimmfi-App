package br.com.vlabs.wiimmfiapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.common.viewbinding.viewBinding
import br.com.vlabs.wiimmfiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        with(binding.bottomNavigation) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            NavigationUI.setupWithNavController(this, navHostFragment.navController)
        }
    }
}