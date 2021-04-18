package com.eugenebaturov.mainpagelm.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.eugenebaturov.mainpagelm.R
import com.eugenebaturov.mainpagelm.ui.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.currentFragment)
        val fragment: Fragment

        if (currentFragment == null) {
            fragment = HomeFragment()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.currentFragment, fragment)
                .commit()
        }
    }
}