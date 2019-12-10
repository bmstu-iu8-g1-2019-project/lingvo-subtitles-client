package com.example.lingvo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lingvo.ui.search.SearchFragment

class MainActivity : AppCompatActivity(), SearchFragment.SearchFragmentContainer {

    private lateinit var sPref: SharedPreferences
    private val SUBTITLE_ID = "subtitle_file_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_tests, R.id.navigation_search, R.id.navigation_user)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        sPref = getPreferences(Context.MODE_PRIVATE)
    }

    override fun onEntrySelected(IDSubtitleFile: String) {
        Log.d("myLogs", "MainActivity onEntrySelected $IDSubtitleFile")
        val ed = sPref.edit()
        ed.putString(SUBTITLE_ID, IDSubtitleFile)
        ed.apply()
    }
}
