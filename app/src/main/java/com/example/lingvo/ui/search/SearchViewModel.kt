package com.example.lingvo.ui.search

import androidx.lifecycle.ViewModel
import com.example.lingvo.models.SearchEntry
import com.example.lingvo.providers.WordsProvider

class SearchViewModel : ViewModel() {
    var items: List<SearchEntry> = emptyList()
        private set

    private val mWordsProvider = WordsProvider()

    fun search(text: String) {
        items = listOf(
            SearchEntry("asd", "sad", "1952846466",0.5f, "sad", "sad"),
            SearchEntry("asd", "sad", "1952846466",0.5f, "sad", "sad")
        )
    }
}