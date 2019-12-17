package com.example.lingvo.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lingvo.R
import com.example.lingvo.models.SearchEntry
import kotlinx.android.synthetic.main.search_item.view.*

class SearchListAdapter(
    private var items: List<SearchEntry>,
    private val mSearchListContainer: SearchListContainer
) :
    RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.mView.setOnClickListener {
            mSearchListContainer.onEntrySelected(item.IDSubtitleFile)
        }

        holder.txtMovieName.text = item.MovieName
        holder.txtMovieYear.text = item.MovieYear
        holder.txtScore.text = item.Score.toString()
        holder.txtUserNickName.text = item.UserNickName
        holder.txtUserRank.text = item.UserRank

        with(holder.mView) {
            tag = item
        }
    }

    fun onUpdateData(data: List<SearchEntry>) {
        items = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val txtMovieName: TextView = mView.txtMovieName
        val txtMovieYear: TextView = mView.txtMovieYear
        val txtScore: TextView = mView.txtScore
        val txtUserNickName: TextView = mView.txtUserNickName
        val txtUserRank: TextView = mView.txtUserRank
    }

    interface SearchListContainer {
        fun onEntrySelected(IDSubtitleFile: String)
    }
}