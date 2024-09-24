package com.example.first_app_1

import android.animation.ObjectAnimator
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
class Figurines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_figurines)

        val BtnCh1 = findViewById<Button>(R.id.button5)
        val BtnCh2 = findViewById<Button>(R.id.button6)
        val viewCh = findViewById<View>(R.id.viewTranslate)

        viewCh.rotation = -45f
        viewCh.scaleY = -0.5f

        ObjectAnimator.ofFloat(viewCh, "translationX", 500f).apply {
            //duration = 2000
            start()
        }

        BtnCh1.setOnClickListener() {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
        BtnCh2.setOnClickListener() {
            val Intent = Intent(this, animation::class.java)
            startActivity(Intent)
        }
    }
}