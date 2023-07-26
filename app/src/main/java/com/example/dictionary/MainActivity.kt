package com.example.dictionary

import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText=findViewById<EditText>(R.id.editTextText)
        val button=findViewById<Button>(R.id.btn)
        val inputout=findViewById<EditText>(R.id.editText1)
        val show=findViewById<EditText>(R.id.editText2)

        editText.setOnClickListener{
            val data=editText.text
            if(!Python.isStarted()){
                Python.start(AndroidPlatform(this))
                val py=Python.getInstance()
                val pyObj=py.getModule("res")
                val obj=pyObj.callAttr(BackEnd, data.toString())
                show.setText(obj.toString())
                inputout.setText("You Searched For: " +data)
            }
            else
            {
                val py=Python.getInstance()
                val pyObj=py.getModule("res")
                val obj=pyObj.callAttr(BackEnd, data.toString())
                show.setText(obj.toString())
                inputout.setText("You Searched For: " +data)

            }

        }



    }
}