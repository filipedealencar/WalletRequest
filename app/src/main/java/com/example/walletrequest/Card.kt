package com.example.walletrequest

val cardList:List<Card> = emptyList()
data class Card( // Classe modelo que irá receber as informações do Json.

    val id:String,
    val name:String,
    val cvv:String,
    val number:String,
    val expirationDate:String,
    val cardType:String
)
