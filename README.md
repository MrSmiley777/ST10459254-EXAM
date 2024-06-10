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
Splash Screen with the student number, name of app, app icon, quit button that quits the application on click and the proceed to app button which takes you to the main screen where you add yr details.
I made the background blue in all of the screens to be like the sky as it relates to it being a weather app. I coloured certain buttons green and red to show caution or to continue throughout the application.

![image](https://github.com/MrSmiley777/ST10459254-EXAM/assets/166629805/935781b7-3222-4294-8c2d-e25ee100cd01)
This is the main screen, all data is entered here which are then added to arrays, you can click on the button to input data directly to the arrays as long as it goes through the error checking, you can click the display average button to find the average of temperatures entered and you can clear your previous entry by clicking on the Clear previous data button. There are two buttons, one for quitting the program and one for going to the next screen to view all data.

![image](https://github.com/MrSmiley777/ST10459254-EXAM/assets/166629805/030276aa-470f-452d-8dd7-91ac79e304cd)
I could not show the actual pop ups in the app as the PC was too slow and couldnt screenshot it in time. This screenshots shows the error handling, if any of the edit boxes are empty it will not be added to the array and a pop up message will be shown to the user. Then once all fields are filled it will check in the Min and Max fields are numbers as it has to be to find out the average, if it is not only a number then a pop up message will be displayed telling the user that they can only enter numbers.

![image](https://github.com/MrSmiley777/ST10459254-EXAM/assets/166629805/6a260c22-9d6f-40a9-9290-33e487f37ff4)
This is the detailed view screen which has textviews to display data entered, the user can go back to the main screen if they desire to make changes. The user can click on the display button to see each day, their min and max temp and their weather conditions, all which the user entered.

Design:
I made the background blue in all of the screens to be like the sky as it relates to it being a weather app. I coloured certain buttons green and red to show caution or to continue throughout the application.


