package com.example.lab_4

import TaskPagerAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.first_app_1.R

class Activity_lab3_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lab3_3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Находим ViewPager
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // Создаем список задач на неделю
        val taskList = listOf(
            Task("Monday, 2024-10-07", "Complete project documentation"),
            Task("Tuesday, 2024-10-08", "Prepare presentation slides"),
            Task("Wednesday, 2024-10-09", "Code review with team"),
            Task("Thursday, 2024-10-10", "Client call at 3:00 PM"),
            Task("Friday, 2024-10-11", "Submit the final report")
        )

        // Устанавливаем адаптер для ViewPager
        val pagerAdapter = TaskPagerAdapter(this, taskList)
        viewPager.adapter = pagerAdapter
    }
}