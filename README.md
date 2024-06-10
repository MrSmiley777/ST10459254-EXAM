# ST10459254-EXAM
Weather App EXAM IMAD5112
Gesaven Pillay 
ST10459254
https://github.com/MrSmiley777/ST10459254-EXAM.git

The purpose of this application is to be able to enter and store information on the weather throughout the week. The app also can be used to find the average temperature of the week. The user must be able to enter information seeminglessly without errors, also if the user makes an error the program must reflect on it and tell the user what is wrong while also giving the option to clear and re-enter any data the user wants. There must be seemless movement between screens while allowing the user to quit the application and see all their details they have entered.

Peudocode:

Splash Screen:
Val:
btnNextpage:Button=findViewById(btnNext)
btnQuit:Button=findviewById(btnQuit)

btnNextPage.OnClick{
  Intent(MainScreen)
  StartActivity(Intent)}
btnQuit.OnClick{
  System.exit(0)}

Main Screen:
Gloable Var:
ArrayDay:Array<String>
ArrayMin:Array<String>
ArrayMax:Array<String>
ArrayCond:Array<String>
    
Val:
edtDay:EditText=findViewById(edtDay)
edtMinTemp:EditText=findViewById(edtMinTemp)
edtMaxTemp:EditText=findViewById(edtMaxTemp)
edtWeatherCond:EditText=findViewById(edtWeatherCond)
btnInput:Button=findViewById(btnInput)
btnDisAvg:Button=findViewById(btnDisplayAvg)
btnClear:Button=findViewById(btnClear)
btnQuit:Button=findViewById(btnQuitApp)
btnNextPage:Button=findViewById(btnNextPage)
txtDisAvg:TextView=findViewById(txtDisplayAvg)

      
ArrayDay= arrayOf<String>("")
ArrayMin= arrayOf<String>("")
ArrayMax= arrayOf<String>("")
ArrayCond= arrayOf<String>("")

btnInput.OnClick{
Val:
  edtEachDay = edtDay.toString()
  edtMin = edtMinTemp.toString()
  edtMax = edtMaxTemp.toString()
  edtCon = edtWeatherCond.toString()

  if (edtEachDay.isEmpty() or edtMin.isEmpty() or edtMax.isEmpty() or edtCon.isEmpty()) {
      Showmessage("You must enter values in ALL boxes before inputting data!")
                  
  else 
      val:
      intMin= edtMin.toIntOrNull()
      intMax = edtMax.toIntOrNull()
      if (intMin == null || intMax == null) {
          Showmessage(""You must enter only numbers for the temperatures!")
      else 
          ArrayDay += edtEachDay
          ArrayMin += edtMin
          ArrayMax += edtMax
          ArrayCond += edtCon
          edtDay.text.clear()
          edtMinTemp.text.clear()
          edtMaxTemp.text.clear()
          edtWeatherCond.text.clear()
          }        
         
btnDisAvg.OnClick {
    txtDisAvg.text=GetAvg().toString()
        }
btnClear.OnClick {
    ArrayDay[counter-1]=""
    ArrayMin[counter-1]=""
    ArrayMax[counter-1]=""
    ArrayCond[counter-1]=""
    edtDay.clear()
    edtMinTemp.clear()
    edtMaxTemp.clear()
    edtWeatherCond.clear()
        }
btnQuit.OnClick {
    System.exit(0)
        }
btnNextPage.setOnClickListener {
    intentNext= Intent(this,DetailedViewScreen::class.java).apply {
    putExtra("ArrayDay",ArrayDay)
    putExtra("ArrayMin",ArrayMin)
    putExtra("ArrayMax",ArrayMax)
    putExtra("ArrayCond",ArrayCond)        
    startActivity(intentNext)
        }

    function GetAvg(){
        var: 
        sumMin= 0.0
        sumMax= 0.0
        for (num in ArrayMin)
            val Min=num.toInt()
            sumMin+= Min
        for (num2 in ArrayMax)
            val Max=num2.toInt()
            sumMax+= Max
        Val:
        TotalTemp=sumMin+sumMax
        avgTemp=TotalTemp/ArrayMin.size
        return avgTemp
    }

Detailed View Screen:
Global Var:
ArrayDay:Array<String>
ArrayMin:Array<String>
ArrayMax:Array<String>
ArrayCond:Array<String>
val:
btnDisplayAll:Button=findViewById(btnDisplayAll)
btnBack:Button=findViewById(btnBack)
        
ArrayDay=intent.getStringArrayExtra("ArrayDay")
ArrayMin=intent.getStringArrayExtra("ArrayMin")
ArrayMax=intent.getStringArrayExtra("ArrayMax")
ArrayCond=intent.getStringArrayExtra("ArrayCond")


btnDisplayAll.OnClick {
    DisplayAll()
        }
btnBack.OnClick {
    intentBack= Intent(this,MainScreen::class.java)
    startActivity(intentBack)
        }
  
  function DisplayAll(){
     var:
     strDay="Day: \n"
     strMin="Min: \n"
     strMax="Max: \n"
     strCond="Weather Condition: \n"
     val:
     txtDay:TextView=findViewById(R.id.txtDay)
     txtMin:TextView=findViewById(R.id.txtMin)
     txtMax:TextView=findViewById(R.id.txtMax)
     txtCond:TextView=findViewById(R.id.txtCond)
       
     for (r in ArrayDay)
        strDay+=r
     for (s in ArrayMin)
        strMin+=s   
     for (t in ArrayMax)
        strMax+=t
     for (u in ArrayCond)
        strCond+=u
        
     txtDay.text=strDay
     txtMin.text=strMin
     txtMax.text=strMax
     txtCond.text=strCond
    }
Screenshots
![image](https://github.com/MrSmiley777/ST10459254-EXAM/assets/166629805/db3a71c0-88cf-45ad-8414-b6e099213c35)

