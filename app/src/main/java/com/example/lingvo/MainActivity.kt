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
import com.example.lingvo.ui.tests.TestsFragment

class MainActivity : AppCompatActivity(),
    SearchFragment.SearchFragmentContainer,
    TestsFragment.TestsFragmentContainer {

    private lateinit var sPref: SharedPreferences

    private val SUBTITLE_ID = "subtitle_file_id"
    private val LOGIN_ID = "login_id"
    private val PASSWORD_ID = "pass_id"

    private var currentIDSubtitleFile: String? = null
    private var mUser: String? = null
    private var mPassword: String? = null

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

        if (sPref.contains(SUBTITLE_ID)) {
            currentIDSubtitleFile = sPref.getString(SUBTITLE_ID, "")
        }

        if (sPref.contains(LOGIN_ID) && sPref.contains(PASSWORD_ID)) {
            mUser = sPref.getString(LOGIN_ID, "")
            mPassword = sPref.getString(PASSWORD_ID, "")
        }
    }

    override fun onEntrySelected(IDSubtitleFile: String) {
        Log.d("myLogs", "MainActivity onEntrySelected $IDSubtitleFile")
        currentIDSubtitleFile = IDSubtitleFile

        val ed = sPref.edit()
        ed.putString(SUBTITLE_ID, IDSubtitleFile)
        ed.apply()
    }

    override fun getCurrentIDSubtitleFile(): String? {
        if (currentIDSubtitleFile != null)
            return currentIDSubtitleFile

        if (sPref.contains(SUBTITLE_ID)) {
            currentIDSubtitleFile = sPref.getString(SUBTITLE_ID, "")
            return currentIDSubtitleFile
        }

        return null
    }

    override fun getCurrentCredentials(): Pair<String, String>? {
        if (mUser != null && mPassword != null)
            return Pair(mUser!!, mPassword!!)

        if (sPref.contains(LOGIN_ID) && sPref.contains(PASSWORD_ID)) {
            mUser = sPref.getString(LOGIN_ID, "")
            mPassword = sPref.getString(PASSWORD_ID, "")
            return Pair(mUser!!, mPassword!!)
        }

        return null
    }
}
