package com.example.lingvo.ui.user

import androidx.lifecycle.ViewModel
import com.example.lingvo.providers.WordsProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class UserViewModel : ViewModel() {
    private val mWordsProvider = WordsProvider()

    var isLogged = false
    var mUser: String? = null
    var mPassword: String? = null

    fun logIn(user: String, password: String) = runBlocking(Dispatchers.IO) {
        if (mWordsProvider.checkUser(user, password)) {
            isLogged = true
            mUser = user
            mPassword = password
        }
    }
}