package com.example.examst10459254

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainScreen : AppCompatActivity() {
    private lateinit var ArrayDay:Array<String>
    private lateinit var ArrayMin:Array<String>
    private lateinit var ArrayMax:Array<String>
    private lateinit var ArrayCond:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val edtDay:EditText=findViewById(R.id.edtDay)
        val edtMinTemp:EditText=findViewById(R.id.edtMinTemp)
        val edtMaxTemp:EditText=findViewById(R.id.edtMaxTemp)
        val edtWeatherCond:EditText=findViewById(R.id.edtWeatherCond)
        val btnInput:Button=findViewById(R.id.btnInput)
        val btnDisAvg:Button=findViewById(R.id.btnDisplayAvg)
        val btnClear:Button=findViewById(R.id.btnClear)
        val btnQuit:Button=findViewById(R.id.btnQuitApp)
        val btnNextPage:Button=findViewById(R.id.btnNextPage)
        val txtDisAvg:TextView=findViewById(R.id.txtDisplayAvg)

        var counter=0
        ArrayDay= arrayOf<String>("")
        ArrayMin= arrayOf<String>("")
        ArrayMax= arrayOf<String>("")
        ArrayCond= arrayOf<String>("")

        btnInput.setOnClickListener {

            val edtEachDay = edtDay.text.toString()
            val edtMin = edtMinTemp.text.toString()
            val edtMax = edtMaxTemp.text.toString()
            val edtCon = edtWeatherCond.text.toString()

            if (edtEachDay.isEmpty() or edtMin.isEmpty() or edtMax.isEmpty() or edtCon.isEmpty()) {
                Toast.makeText(
                    this,
                    "You must enter values in ALL boxes before inputting data!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intMin: Int? = edtMin.toIntOrNull()
                val intMax: Int? = edtMax.toIntOrNull()
                if (intMin == null || intMax == null) {
                    Toast.makeText(
                        this,
                        "You must enter only numbers for the temperatures!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    ArrayDay += edtEachDay
                    ArrayMin += edtMin
                    ArrayMax += edtMax
                    ArrayCond += edtCon
                    edtDay.text.clear()
                    edtMinTemp.text.clear()
                    edtMaxTemp.text.clear()
                    edtWeatherCond.text.clear()
                    counter+=1
                }
            }
        }

        btnDisAvg.setOnClickListener {
            txtDisAvg.text=GetAvg().toString()
        }
        btnClear.setOnClickListener {
            ArrayDay[counter-1]=""
            ArrayMin[counter-1]=""
            ArrayMax[counter-1]=""
            ArrayCond[counter-1]=""
            edtDay.text.clear()
            edtMinTemp.text.clear()
            edtMaxTemp.text.clear()
            edtWeatherCond.text.clear()
        }
        btnQuit.setOnClickListener {
            System.exit(0)
        }
        btnNextPage.setOnClickListener {
            val intentNext= Intent(this,DetailedViewScreen::class.java).apply {
                putExtra("ArrayDay",ArrayDay)
                putExtra("ArrayMin",ArrayMin)
                putExtra("ArrayMax",ArrayMax)
                putExtra("ArrayCond",ArrayCond)
            }
            startActivity(intentNext)
        }

    }
    fun GetAvg():Double{
        var sumMin= 0.0
        var sumMax= 0.0
        for (num in ArrayMin){
            val Min=num.toInt()
            sumMin+= Min
        }
        for (num2 in ArrayMax){
            val Max=num2.toInt()
            sumMax+= Max
        }
        val TotalTemp:Double=sumMin+sumMax
        val avgTemp:Double=TotalTemp/ArrayMin.size
        return avgTemp
    }
}