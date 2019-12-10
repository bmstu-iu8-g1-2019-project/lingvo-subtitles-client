package com.example.lingvo.ui.tests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.lingvo.R

class TestsFragment : Fragment() {

    private lateinit var testsViewModel: TestsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testsViewModel =
            ViewModelProviders.of(this).get(TestsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_tests, container, false)
    }
}