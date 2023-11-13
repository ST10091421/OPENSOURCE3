package com.example.navigationdrawer

import QuickIdentificationGuideFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.nav_fragment.*
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }

    private fun onBackPressedMethod() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            finish()
        }
    }

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val header = navigationView.getHeaderView(0)
        val userNameTxT = header.findViewById<TextView>(R.id.userNameTxT)
        val emailTxT = header.findViewById<TextView>(R.id.emailTxT)
        val profileImg = header.findViewById<ImageView>(R.id.profileImg)

        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        ///Default Navigation bar Tab Selected
        replaceFragment(HomeFragment())
        navigationView.setCheckedItem(R.id.nav_home)
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navFragment, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(HomeFragment())
                title = "Home"
            }
            R.id.nav_profile -> {
                replaceFragment(ProfileFragment())
                title = "Profile"
            }
            R.id.nav_settings -> {
                replaceFragment(SettingsFragment())
                title = "Settings"
            }
            R.id.nav_view -> {
                replaceFragment(ViewObservationsFragment())
                title = "View Observations"
            }
            R.id.nav_guide -> {
                replaceFragment(QuickIdentificationGuideFragment())
                title = "Quick Guide"
            }
            R.id.nav_gamification -> {
                replaceFragment(GamificationFragment())
                title = "Gamification"
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_share -> {
                shareAction()
                return true
            }
            R.id.nav_rate -> {
                rateAction()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun shareAction() {
        // Your code to handle the share action
        // Open share dialog, send intent, etc.
        Toast.makeText(this, "Share with friends", Toast.LENGTH_LONG).show()
    }

    private fun rateAction() {
        // Your code to handle the rate action
        // Open rate dialog, open app store, etc.
        Toast.makeText(this, "Rate us", Toast.LENGTH_LONG).show()
    }
}




