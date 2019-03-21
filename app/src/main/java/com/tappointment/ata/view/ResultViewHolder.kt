package com.tappointment.ata.view

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.tappointment.ata.R

class ResultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var cardView: CardView = itemView.findViewById(R.id.cardView)
    var imageView: ImageView = itemView.findViewById(R.id.imageView)
    var subcategoryTextView: TextView = itemView.findViewById(R.id.subcategoryTextView)
    var distanceTextView: TextView = itemView.findViewById(R.id.distanceTextView)
    var addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
    var fantasyNameTextView: TextView = itemView.findViewById(R.id.fantasyNameTextView)
    var bookButton: RelativeLayout = itemView.findViewById(R.id.bookButton)

}