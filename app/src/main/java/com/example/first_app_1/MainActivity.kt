package com.example.first_app_1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.widget.Toast

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
        val btnSum = findViewById<Button>(R.id.button)
        val btnChange = findViewById<Button>(R.id.button7)
        btnChInc.setOnClickListener {
            numb++
            txtCh.text = numb.toString()
            Log.d("NUMB", numb.toString())
        }
        btnChDec.setOnClickListener {
            numb--
            txtCh.text = numb.toString()
            Log.d("NUMB", numb.toString())
        }
        btnChCl.setOnClickListener {
            txtCh.text = "0"
            numb = 0
            Log.d("NUMB", numb.toString())
        }
        btnSum.setOnClickListener {
            // Creating a builder
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Calculator")

            //setting up dialogue window
            val customLayout: View = layoutInflater.inflate(R.layout.dialogue_sum_layout, null)
            builder.setView(customLayout)

            builder.setPositiveButton("Sum") { dialog: DialogInterface?, _: Int ->
                val f_num1 = customLayout.findViewById<EditText>(R.id.editText)
                val f_num2 = customLayout.findViewById<EditText>(R.id.editText1)
                Log.d("Sum", (f_num1.text.toString().toInt() + f_num2.text.toString().toInt()).toString())
            }
            builder.setNegativeButton("Cancel") {dialog: DialogInterface?, _: Int ->}

            val dialog = builder.create()
            dialog.show()
        }
        btnChange.setOnClickListener() {
            val Intent = Intent(this, Figurines::class.java)
            startActivity(Intent)
        }
    }
}