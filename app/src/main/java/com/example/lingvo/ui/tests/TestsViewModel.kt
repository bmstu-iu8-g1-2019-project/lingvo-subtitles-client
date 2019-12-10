package com.example.lingvo.ui.tests

import androidx.lifecycle.ViewModel
import com.example.lingvo.models.Card
import com.example.lingvo.providers.WordsProvider

class TestsViewModel : ViewModel() {
    var items: List<Card> = emptyList()
        private set

    var currentIDSubtitleFile: String? = null
    var isLogged = false

    private val mWordsProvider = WordsProvider()

    fun logIn(user: String, password: String) {
        mWordsProvider.logIn(user, password)
    }

    fun load(IDSubtitleFile: String) {
        items = mWordsProvider.getTest(IDSubtitleFile)
    }
}