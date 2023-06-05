package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btOpencard = findViewById<Button>(R.id.btCadcard)
        val btListcards = findViewById<Button>(R.id.myCards)

        btOpencard.setOnClickListener {
            val skipCreatepage = Intent(this,RegisterCard::class.java)
            startActivity(skipCreatepage)
        }
        btListcards.setOnClickListener {
             val skipListcardpage = Intent(this,ShowAllCards::class.java)
            startActivity(skipListcardpage)
        }


    }
}