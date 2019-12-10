package com.example.lingvo.ui.search

import androidx.lifecycle.ViewModel
import com.example.lingvo.models.SearchEntry
import com.example.lingvo.providers.WordsProvider

class SearchViewModel : ViewModel() {
    var items: List<SearchEntry> = emptyList()
        private set

    private val mWordsProvider = WordsProvider()

    fun search(text: String) {
        items = mWordsProvider.search(text)
    }
}