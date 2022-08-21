package com.kamikaze.firstkotlinprogram

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdaptor(val context:Context, private val mylist: ArrayList<ResponseItem>) :
    RecyclerView.Adapter<CustomAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recycler_view_practice, parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val University = itemView.findViewById<TextView>(R.id.Universityname)
        val Country = itemView.findViewById<TextView>(R.id.Country)
        val Domain = itemView.findViewById<TextView>(R.id.Domain)
        val Website = itemView.findViewById<Button>(R.id.website)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mylist[position]
        holder.Country.text = ItemsViewModel.country
        holder.Domain.text = ItemsViewModel.domains.toString()
        holder.University.text = ItemsViewModel.name
        Log.e("TAG", "onBindViewHolder: "+ItemsViewModel.web_pages[0] )
        val context = holder.Website.context
        holder.Website.setOnClickListener {
            nothing(context, ItemsViewModel.web_pages)
            Log.e("TAG", "onBindViewHolder: "+ItemsViewModel.web_pages[0], )
        }
    }

    private fun nothing(context: Context, url: ArrayList<String>) {
        val webpage: Uri = Uri.parse(url[0])
        Log.e("TAG", "onBind: "+webpage, )
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

}