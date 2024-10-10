package com.example.lab_4

import TaskAdapter
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.first_app_1.R

class Activity_lab3_2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskList: MutableList<Task>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lab3_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*
        5) Создать приложение с одной кнопкой и текстовым полем. После нажатия на
        кнопку отображается диалог для выбора времени. После согласия с
        результатом ввода выбранное время отображается в текстовом поле.
         */
        val BtnTime : Button = findViewById(R.id.buttonPressTime)
        val TxtTime : TextView = findViewById(R.id.textViewPressTime)
        BtnTime.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            //setting up dialogue window
            val customLayout: View = layoutInflater.inflate(R.layout.dialogue_time, null)
            builder.setView(customLayout)
            val TimePick : TimePicker = customLayout.findViewById(R.id.timePick)
            TimePick.setOnTimeChangedListener { timePicker, hour, minute ->
                TxtTime.text = "$hour hours, $minute minutes"
            }

            builder.setPositiveButton("Done") { dialog: DialogInterface?, _: Int -> }

            val dialog = builder.create()
            dialog.show()
        }
        /*
        6) Создать приложение со списком SilicaListView, из задач на неделю. Задачи
        должны содержать дату и описание. В списке задачи группировать по датам.
        10) Создать приложение со списком и контекстным меню. После выбора элемента
        контекстного меню отобразить в консоли название выбранного элемента меню
        и индекс элемента списка.
         */
        recyclerView = findViewById(R.id.recycleList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        taskList = mutableListOf(
            Task("Monday", "do smth"),
            Task("Monday", "do smth"),
            Task("Tuesday", "do smth"),
            Task("Friday", "do smth")
        )

        taskAdapter = TaskAdapter(groupTasksByDate(taskList), this)
        recyclerView.adapter = TaskAdapter(taskList, this)

        val BtnSwap : Button = findViewById(R.id.buttonSwap)
        BtnSwap.setOnClickListener {
            val intent = Intent(this, Activity_lab3_3::class.java)
            startActivity(intent)
        }
    }

    private fun groupTasksByDate(tasks: List<Task>): List<Task> {
        val groupedTasks = mutableListOf<Task>()
        var lastDate = ""

        for (task in tasks) {
            if (task.date != lastDate) {
                groupedTasks.add(Task(task.date, ""))  // Заголовок для группы (дата)
                lastDate = task.date
            }
            groupedTasks.add(Task("", task.description))  // Добавляем задачи с одинаковой датой
        }

        return groupedTasks
    }

}