package com.example.lingvo.ui.tests

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lingvo.R
import com.example.lingvo.models.Card
import kotlinx.android.synthetic.main.word_item.view.*

class TestsListAdapter(
    private var items: List<Card>,
    private val mTestsListContainer: TestsListContainer
) :
    RecyclerView.Adapter<TestsListAdapter.ViewHolder>() {

    private var learnedWordCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.txtWord.text = item.word
        holder.txtTranslatedWord.text = item.translated_word
        holder.txtTranslatedWord.visibility = View.INVISIBLE

        holder.mView.setOnClickListener {
            onCardClicked(holder)
        }

        with(holder.mView) {
            tag = item
        }
    }

    fun onUpdateData(data: List<Card>) {
        items = data
        learnedWordCount = 0
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    private fun onCardClicked(holder: ViewHolder) {
        if (holder.txtTranslatedWord.visibility == View.VISIBLE) {
            return
        }

        learnedWordCount++
        holder.txtTranslatedWord.visibility = View.VISIBLE

        if (learnedWordCount == items.size) {
            mTestsListContainer.onTestCompleted()
        }
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val txtWord: TextView = mView.txtWord
        val txtTranslatedWord: TextView = mView.txtTranslatedWord
    }

    interface TestsListContainer {
        fun onTestCompleted()
    }
}