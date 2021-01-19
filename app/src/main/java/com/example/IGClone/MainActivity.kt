package com.example.IGClone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.IGClone.fragment.HomeFragment
import com.example.IGClone.fragment.SearchFragment
import com.example.IGClone.fragment.ProfileFragment
import com.example.IGClone.fragment.NotificationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavListener)
        val frag = supportFragmentManager.beginTransaction()
        frag.add(R.id.frag_container, HomeFragment())
        frag.commit()
    }

    private val onBottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { i ->
        var selectedFragment: Fragment = HomeFragment()

        when (i.itemId) {
            R.id.itemhome -> {
                selectedFragment = HomeFragment()

            }
            R.id.itemsearch -> {
                selectedFragment = SearchFragment()

            }
            R.id.itempost -> {
                startActivity(Intent(this,AddPost::class.java))
            }

            R.id.itemnotification -> {
                selectedFragment = NotificationFragment()
            }

            R.id.itemprofile -> {
                selectedFragment = ProfileFragment()
            }


        }

        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.frag_container, selectedFragment)
        frag.commit()

        true
    }
}