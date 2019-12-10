package com.example.lingvo.ui.tests

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lingvo.R
import kotlinx.android.synthetic.main.fragment_tests.view.*

class TestsFragment : Fragment(), TestsListAdapter.TestsListContainer {

    private lateinit var testsViewModel: TestsViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testsViewModel = ViewModelProviders.of(this).get(TestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tests, container, false)


        recyclerView = root.listTest.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TestsListAdapter(testsViewModel.items, this@TestsFragment)
        }

        activity.let { it as TestsFragmentContainer }
            .getCurrentCredentials()
            ?.also {
                testsViewModel.logIn(it.first, it.second)
                testsViewModel.isLogged = true
            }

        if (!testsViewModel.isLogged) {
            Log.d("myLogs", "TestsFragment isLogged=false")
            return root
        }

        testsViewModel.currentIDSubtitleFile = activity
            .let { it as TestsFragmentContainer }
            .getCurrentIDSubtitleFile()
            ?.also {
                Log.d("myLogs", "TestsFragment loading $it")
                testsViewModel.load(it)
                recyclerView.adapter
                    .let { it as TestsListAdapter }
                    .onUpdateData(testsViewModel.items)
            }

        return root
    }

    override fun onTestCompleted() {
        Log.d("myLogs", "TestsFragment onTestCompleted")
    }

    interface TestsFragmentContainer {
        fun getCurrentIDSubtitleFile(): String?
        fun getCurrentCredentials(): Pair<String, String>?
    }
}
