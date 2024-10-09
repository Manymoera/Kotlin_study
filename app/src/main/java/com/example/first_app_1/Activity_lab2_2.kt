package com.example.first_app_1

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_lab2_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lab32)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val TimePick : TimePicker = findViewById(R.id.timeP)
        TimePick.setOnTimeChangedListener { timePicker, hour, minute ->
            Log.d("Time of day: ", "$hour hours, $minute minutes")
        }
        val DrList : Spinner = findViewById(R.id.spinner1)
        val names = arrayOf("Andrew", "Denis", "Evgeniy", "Lera")
        val ArrayAd = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, names)
        DrList.adapter = ArrayAd
        DrList.setSelection(0,false)
        DrList.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                Log.d("Selected Name: ", DrList.selectedItem.toString())
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>) {}
        }
        val TxtSl : TextView = findViewById(R.id.textView2)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TxtSl.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}
