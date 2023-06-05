package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.UUID

class RegisterCard : AppCompatActivity() {

    private lateinit var config: RetroConfig

    private var service:CardService? = null

    companion object {
        const val KEY_CARD = "KEY_CARD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registercard)

       config = RetroConfig()
        service = config.cardService




        val edCardNumber = findViewById<EditText>(R.id.edCardNumber)
        val edName = findViewById<EditText>(R.id.edNameTitular)
        val edVenc = findViewById<EditText>(R.id.edVenci)
        val edCodSeg = findViewById<EditText>(R.id.edCodseg)
        val btAvancar = findViewById<Button>(R.id.btavancar)

        btAvancar.setOnClickListener {
            val idCard: String = UUID.randomUUID().toString()
            val cardType = "GREEN"
            val name = edName.text
            val edVenc = edVenc.text
            val edCodSeg = edCodSeg.text
            val cardNumber = edCardNumber.text

            val newCard = Card(
                id = idCard,
                name = name.toString(),
                cvv = edCodSeg.toString(),
                expirationDate = edVenc.toString(),
                cardType = cardType,
                number = cardNumber.toString()

            )


            executarRequest(newCard)

        }



    }

    private fun executarRequest(newCard: Card){
        service?.createCard(newCard)?.enqueue(object: Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                Toast.makeText(
                    this@RegisterCard,
                    "Cadastro Realizado com sucesso",
                    Toast.LENGTH_LONG
                ).show()
                Intent(this@RegisterCard,ConfirmCard::class.java).also {
                    it.putExtra(KEY_CARD,newCard.id)
                    startActivity(it)
                }



            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Toast.makeText(this@RegisterCard, "Erro, Falha na comunicação", Toast.LENGTH_LONG)
                    .show()
            }

        })

        }
    }

