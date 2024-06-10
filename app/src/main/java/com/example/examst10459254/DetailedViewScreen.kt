package com.example.examst10459254

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedViewScreen : AppCompatActivity() {
    private lateinit var ArrayDay:Array<String>
    private lateinit var ArrayMin:Array<String>
    private lateinit var ArrayMax:Array<String>
    private lateinit var ArrayCond:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)

        val btnDisplayAll:Button=findViewById(R.id.btnDisplayAll)
        val btnBack:Button=findViewById(R.id.btnBack)
        ArrayDay=intent.getStringArrayExtra("ArrayDay")?: arrayOf()
        ArrayMin=intent.getStringArrayExtra("ArrayMin")?: arrayOf()
        ArrayMax=intent.getStringArrayExtra("ArrayMax")?: arrayOf()
        ArrayCond=intent.getStringArrayExtra("ArrayCond")?: arrayOf()


        btnDisplayAll.setOnClickListener {
            DisplayAll()
        }
        btnBack.setOnClickListener {
            val intentBack= Intent(this,MainScreen::class.java)
            startActivity(intentBack)
        }
    }
    fun DisplayAll(){
        var strDay="Day: \n"
        var strMin="Min: \n"
        var strMax="Max: \n"
        var strCond="Weather Condition: \n"
        val txtDay:TextView=findViewById(R.id.txtDay)
        val txtMin:TextView=findViewById(R.id.txtMin)
        val txtMax:TextView=findViewById(R.id.txtMax)
        val txtCond:TextView=findViewById(R.id.txtCond)
        for (r in ArrayDay){
            strDay+="${r}\n"
        }
        for (s in ArrayMin){
            strMin+="${s}\n"
        }
        for (t in ArrayMax){
            strMax+="${t}\n"
        }
        for (u in ArrayCond){
            strCond+="${u}\n"
        }
        txtDay.text=strDay
        txtMin.text=strMin
        txtMax.text=strMax
        txtCond.text=strCond
    }

}