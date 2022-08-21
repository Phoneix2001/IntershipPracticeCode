package com.kamikaze.firstkotlinprogram.quotesdatamodel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.firstkotlinprogram.R
import kotlinx.android.synthetic.main.activity_recycler_view_layout_data_binding.view.*
import kotlinx.android.synthetic.main.quotes_item_layout.view.*

class QuotesPagingAdaptor:PagingDataAdapter<Result,QuotesPagingAdaptor.QuotesViewHolder>(COMPARATOR) {
    class QuotesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val dateAdded    = itemView.findViewById<TextView>(R.id.firstid)
val quote = itemView.findViewById<TextView>(R.id.secondid)
        val author =itemView.findViewById<TextView>(R.id.thirdid)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.dateAdded.text = item.dateAdded
            holder.quote.text = item.content
            holder.author.text = item.author
            Log.e("TAG", "onBindViewHolder: "+ item.content )
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quotes_item_layout,parent,false)
return QuotesViewHolder(view)   }
    companion object{
        private val COMPARATOR = object :DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
return oldItem == newItem
            }

        }
    }
}