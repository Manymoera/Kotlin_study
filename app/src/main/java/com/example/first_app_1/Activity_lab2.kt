package com.example.first_app_1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_lab2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lab2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val BtnTgl : ToggleButton = findViewById(R.id.toggleButton)
        val BtnCh : Button = findViewById(R.id.buttonN)
        BtnTgl.setOnClickListener {
            if(BtnTgl.isChecked) {
                BtnTgl.setBackgroundColor(Color.parseColor("#D7B2B2"))
            } else {
                BtnTgl.setBackgroundColor(Color.parseColor("#DBD0D0"))
            }
        }
        val BtnHold : Button = findViewById(R.id.buttonHold)
        val TxtHold : TextView = findViewById(R.id.textViewHold)
        @Suppress("ClickableViewAccessibility")
        BtnHold.setOnTouchListener{ v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Button press
                    TxtHold.text = getString(R.string.buttonHold)
                    true // return true to handle the event
                }
                MotionEvent.ACTION_UP -> {
                    // Button release
                    TxtHold.text = getString(R.string.buttonHoldR)
                    true
                }
                else -> false
            }
        }
        val BtnCount : Button = findViewById(R.id.buttonCount)
        var ClickCount : Int = 0
        BtnCount.setOnClickListener {
            ClickCount++
            BtnCount.text = ClickCount.toString()
        }
        val DatePick : DatePicker = findViewById(R.id.datePicker)
        DatePick.setOnDateChangedListener { datePicker, year, monthOfYear, dayOfMonth ->
            Log.d("Date picked: ", "Day: $dayOfMonth Month: $monthOfYear Year: $year")
        }
        BtnCh.setOnClickListener() {
            val Intent = Intent(this, Activity_lab2_2::class.java)
            startActivity(Intent)
        }
    }
}