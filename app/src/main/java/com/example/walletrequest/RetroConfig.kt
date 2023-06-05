package com.example.walletrequest

import android.service.carrier.CarrierService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroConfig {
 // Instanciando um Retrofit e inserindo os valores nos atributos deste objeto.
 val retroConf = Retrofit.Builder().baseUrl("https://wallet-backend-theta.vercel.app/").addConverterFactory(GsonConverterFactory.create())
        .build()// Esse autoriza a instancia do Retrofit.

    val cardService:CardService = retroConf.create(CardService::class.java)
}