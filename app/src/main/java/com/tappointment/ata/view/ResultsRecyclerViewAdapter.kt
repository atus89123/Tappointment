package com.tappointment.ata.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.tappointment.ata.R
import com.tappointment.ata.entity.Result

class ResultsRecyclerViewAdapter(private val context: Context?, private val results: List<Result>): RecyclerView.Adapter<ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_result, parent, false)
        return ResultViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = results[position]

        var picUrl: String? = null
        if (result.picture.size > 0) {
            picUrl = result.picture[0].size_1024
            Picasso.with(context).load(picUrl).fit().error(context?.getDrawable(R.drawable.default_image)).into(holder.imageView)
        } else {
            Picasso.with(context).load(R.drawable.default_image).fit().into(holder.imageView)
        }

        holder.subcategoryTextView.text = result.subcategory_name
        holder.distanceTextView.text = result.distance_km.toString()
        holder.addressTextView.text = "${result.postalcode} ${result.city}, ${result.address_line1}"
        holder.fantasyNameTextView.text = result.fantasy_name

        holder.bookButton.setOnClickListener {
            Toast.makeText(context, "BOOK button pressed", Toast.LENGTH_SHORT).show()
        }

        holder.cardView.setOnClickListener {
            Toast.makeText(context, "CardView clicked", Toast.LENGTH_LONG).show()
        }


    }
}