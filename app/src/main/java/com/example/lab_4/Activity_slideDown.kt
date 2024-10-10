package com.example.lab_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.first_app_1.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView

class Activity_slideDown : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var textView: TextView
    private lateinit var openBottomMenuButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_down)

        drawerLayout = findViewById(R.id.drawerLayout)
        textView = findViewById(R.id.textView)
        openBottomMenuButton = findViewById(R.id.openBottomMenuButton)

//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)

        openBottomMenuButton.setOnClickListener { openBottomSheetMenu() }
    }

    private fun openBottomSheetMenu() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = LayoutInflater.from(applicationContext)
            .inflate(R.layout.bottom_menu, null)

        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()

        bottomSheetView.findViewById<View>(R.id.itemA).setOnClickListener {
            textView.text = "SmthA"
            bottomSheetDialog.dismiss()
        }

        bottomSheetView.findViewById<View>(R.id.itemB).setOnClickListener {
            textView.text = "SmthB"
            bottomSheetDialog.dismiss()
        }

        bottomSheetView.findViewById<View>(R.id.itemC).setOnClickListener {
            textView.text = "SmthC"
            bottomSheetDialog.dismiss()
        }
    }
}