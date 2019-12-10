package com.example.lingvo.ui.tests

import androidx.lifecycle.ViewModel
import com.example.lingvo.models.Card
import com.example.lingvo.providers.WordsProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class TestsViewModel : ViewModel() {
    var items: List<Card> = emptyList()
        private set

    var currentIDSubtitleFile: String? = null
    var isLogged = false

    private val mWordsProvider = WordsProvider()

    fun logIn(user: String, password: String) {
        mWordsProvider.logIn(user, password)
    }

    fun load(IDSubtitleFile: String) = runBlocking(Dispatchers.IO) {
        items = mWordsProvider.getTest(IDSubtitleFile)
    }
}