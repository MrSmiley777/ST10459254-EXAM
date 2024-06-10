package com.example.examst10459254

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNextPage:Button=findViewById(R.id.btnNext)
        val btnQuit:Button=findViewById(R.id.btnQuit)

        btnNextPage.setOnClickListener {
            val intentNext= Intent(this,MainScreen::class.java)
            startActivity(intentNext)
        }
        btnQuit.setOnClickListener {
            System.exit(0)
        }
    }
}