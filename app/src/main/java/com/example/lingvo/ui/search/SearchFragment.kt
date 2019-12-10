package com.example.lingvo.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lingvo.R
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : Fragment(), SearchListAdapter.SearchListContainer {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)

        recyclerView = root.searchList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SearchListAdapter(searchViewModel.items, this@SearchFragment)
        }

        root.btnSearch.setOnClickListener {
            val txt = root.edtSearch.text.toString()
            if (txt.isNotEmpty())
                onSearchClicked(txt)
        }

        return root
    }

    override fun onEntrySelected(IDSubtitleFile: String) {
        activity.let { it as SearchFragmentContainer }.onEntrySelected(IDSubtitleFile)
    }

    private fun onSearchClicked(text: String) {
        searchViewModel.search(text)
        recyclerView.adapter
            .let { it as SearchListAdapter }
            .onUpdateData(searchViewModel.items)
    }

    interface SearchFragmentContainer {
        fun onEntrySelected(IDSubtitleFile: String)
    }

}