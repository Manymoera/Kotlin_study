package com.example.first_app_1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var numb : Int
        numb = 0
        val btnChInc = findViewById<Button>(R.id.button4)
        val btnChDec = findViewById<Button>(R.id.button3)
        val btnChCl = findViewById<Button>(R.id.button2)
        val txtCh = findViewById<TextView>(R.id.textView)
        btnChInc.setOnClickListener {
            numb++
            txtCh.text = numb.toString()
        }
        btnChDec.setOnClickListener {
            numb--
            txtCh.text = numb.toString()
        }
        btnChCl.setOnClickListener {
            txtCh.text = "0"
            numb = 0
            Log.d("TAG", "message")
        }
    }
}