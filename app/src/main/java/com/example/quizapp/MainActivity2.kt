package com.example.quizapp
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import java.util.Calendar
import java.util.Date
import java.util.*
import android.content.Context

class MainActivity2 : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var resetButton: Button
    private lateinit var radioButton: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var chkcheckBox: CheckBox
    private lateinit var chkcheckBox2: CheckBox
    private lateinit var chkcheckBox3: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submitButton = findViewById(R.id.button)
        resetButton = findViewById(R.id.button2)
        radioButton=findViewById(R.id.radioButton)
        radioButton2=findViewById(R.id.radioButton2)
        radioButton3=findViewById(R.id.radioButton3)
        chkcheckBox=findViewById(R.id.checkBox)
        chkcheckBox2=findViewById(R.id.checkBox2)
        chkcheckBox3=findViewById(R.id.checkBox3)
        submitButton.setOnClickListener {
                      executeSubmit()
        }

        submitButton.setOnClickListener {
            executeReset()
        }
    }
    fun executeSubmit(){

        val dialogBuilder = AlertDialog.Builder(this)

        val currentTime: Date = Calendar.getInstance().getTime()
        var timeString = currentTime.toString()

        dialogBuilder.setMessage("You submitted on $timeString, Your achieved ${getScore()}%")
            .setCancelable(true)
            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, id ->
                dialog.dismiss()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Congratulations! ")
        alert.show()
    }

    fun executeReset(){
        radioButton.isChecked = false
        radioButton2.isChecked = false
        radioButton3.isChecked = false
        chkcheckBox.isChecked = false
        chkcheckBox2.isChecked = false
        chkcheckBox3.isChecked = false
    }
    fun getScore():Int{
        var score = 0
        if ( radioButton3.isChecked == true) {
            score += 50
        }
        if ( chkcheckBox.isChecked == true && chkcheckBox2.isChecked == false && chkcheckBox3.isChecked == true)
        {
            score += 50
        }
        return score
    }
   }