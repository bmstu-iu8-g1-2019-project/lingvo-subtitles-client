package com.example.lingvo.ui.tests.word_card_learn

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.lingvo.R

class WordCardLearnFragment : Fragment() {

    companion object {
        fun newInstance() = WordCardLearnFragment()
    }

    private lateinit var learnViewModel: WordCardLearnViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_word_card_learn, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        learnViewModel = ViewModelProviders.of(this).get(WordCardLearnViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
