package com.example.lab_4

import FragmentOne
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.first_app_1.R

class Lab3_task2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lab3_task2)

        // Загрузка первого фрагмента при запуске приложения
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentOne(), "FirstFragment")
                .commit()
        }
    }
}