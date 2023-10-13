package com.example.menu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.menu1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //lateinit var toolbar: ActionBar
    //private lateinit var binding: ActivityMainBinding
    lateinit var bottomNav : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(FragmentHome())
        bottomNav =findViewById(R.id.bottomNavigationView) as BottomNavigationView
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        val menu: Menu


        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> replaceFragment(FragmentHome())
                R.id.porfile -> replaceFragment(FragmentPorfile())
                R.id.settings -> replaceFragment(FragmentSettings())

                else -> {
                }

        }
        true
    }}

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_layout, fragment)
        fragmentTransition.commit()
    }
}
