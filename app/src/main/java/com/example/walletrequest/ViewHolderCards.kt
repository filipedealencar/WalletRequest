package com.example.walletrequest

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ViewHolderCards(itemView:View): RecyclerView.ViewHolder(itemView) {

    private var clContainer:ConstraintLayout
    private var tvNamecard: TextView
    private var tvcardNumber:TextView
    private var tvVenci:TextView
    private var tvCodseg:TextView
    private var tvcolorCard:TextView

    init {
        clContainer = itemView.findViewById(R.id.clContainer)
        tvNamecard = itemView.findViewById(R.id.tvnameTitular)
        tvcardNumber= itemView.findViewById(R.id.tvnumberCard)
        tvVenci = itemView.findViewById(R.id.tvVenci)
        tvCodseg = itemView.findViewById(R.id.tvCodseg)
        tvcolorCard = itemView.findViewById(R.id.tvColorcard)
    }

    fun configItens(card: Card){
        tvNamecard.text = card.name
        tvcardNumber.text = card.number
        tvVenci.text = card.expirationDate
        tvCodseg.text = card.cvv
       tvcolorCard.text = card.cardType
        if (tvcolorCard.text == "GREEN"){
         clContainer.setBackgroundResource(R.drawable.green_card)
        }else{
            clContainer.setBackgroundResource(R.drawable.back_card)
        }

    }



}