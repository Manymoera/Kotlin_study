package com.example.lab_4

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.first_app_1.Activity_lab2_2
import com.example.first_app_1.BlankPage
import com.example.first_app_1.R
import java.util.Vector

class Activity_lab3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lab3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*
        1) Создать приложение, которое будет отображать страницу с двумя кнопками
        “Назад” и “Вперёд”. Первая удалит текущую страницу со стека, вторая добавит
        новую. Также на экране нужно отображать текущую глубину стека.
        */
        val BtnB: Button = findViewById(R.id.buttonLab3Back)
        val BtnN: Button = findViewById(R.id.buttonLab3Next)
        val TxtS: TextView = findViewById(R.id.textViewStack)
        val arrayIntent = Vector<Intent>()
        var StPoint: Int = 1
        BtnN.setOnClickListener {
            if(arrayIntent.isEmpty()) {
                arrayIntent.add(0, Intent(this, Activity_lab2_2::class.java))
                TxtS.text = "Stack depth: $StPoint"
            }
            else {
                arrayIntent.add(StPoint, Intent(this, Activity_lab2_2::class.java))
                StPoint++
                TxtS.text = "Stack depth: $StPoint"
            }
        }
        BtnB.setOnClickListener {
            if(!arrayIntent.isEmpty()){
                StPoint--
                arrayIntent.removeAt(StPoint)
                TxtS.text = "Stack depth: $StPoint"
                if(StPoint == 0) {
                    StPoint = 1
                }
            } else { StPoint = 1 }
        }
        /*
        2) Создать приложение из двух страниц. Первая страница содержит две кнопки
        “Добавить страницу” и “Убрать страницу”. Первая кнопка добавит вторую
        страницу как прикреплённую, вторая кнопка её удалит. На второй странице
        должна быть кнопка для возврата на первую страницу без закрытия второй.
        */
        val BtnAdd : Button = findViewById(R.id.buttonPageAdd)
        val BtnDel : Button = findViewById(R.id.buttonPageDel)
        val BtnView : Button = findViewById(R.id.buttonPageView)
        var Intent  = Intent(this, BlankPage::class.java)
        BtnAdd.setOnClickListener {
            if(Intent.data == null) {
                Intent(this, BlankPage::class.java).also { startActivity(it) }
            }
        }
        BtnDel.setOnClickListener {
            //Intent.setData(null)
        }
        BtnView.setOnClickListener {
            if(Intent.data == null) {
                startActivity(Intent)
            }
        }
        /*
        3) Создать приложение с одной кнопкой и текстовом поле. После нажатия на
        кнопку отображается диалог для ввода текста. После согласия с результатом
        введённый текст отображается в текстовое поле.
         */
        val BtnPressAdd : Button = findViewById(R.id.buttonPressText)
        val TxtPressAdd : TextView = findViewById(R.id.textViewPressText)
        BtnPressAdd.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            //setting up dialogue window
            val customLayout: View = layoutInflater.inflate(R.layout.dialogue_write, null)
            builder.setView(customLayout)

            builder.setPositiveButton("Done") { dialog: DialogInterface?, _: Int ->
                val txtDial = customLayout.findViewById<EditText>(R.id.editText)
                TxtPressAdd.text = txtDial.text
            }
            builder.setNegativeButton("Cancel") { dialog: DialogInterface?, _: Int ->}

            val dialog = builder.create()
            dialog.show()
        }
        /*
        4) Создать приложение с одной кнопкой и текстовым полем. После нажатия на
        кнопку отображается диалог для выбора даты. После согласия с результатом
        ввода выбранная дата отображается в текстовое поле.
         */
        val BtnPressDate : Button = findViewById(R.id.buttonPressDate)
        val TxtPressDate : TextView = findViewById(R.id.textViewPressDate)
        BtnPressDate.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            //setting up dialogue window
            val customLayout: View = layoutInflater.inflate(R.layout.dialogue_date, null)
            builder.setView(customLayout)
            val DatePress : CalendarView = customLayout.findViewById(R.id.calendarView)
            DatePress.setOnDateChangeListener { _ : CalendarView, year, month, dayOfMonth ->
                TxtPressDate.text = "$dayOfMonth.$month.$year"
            }

            builder.setPositiveButton("Done") { dialog: DialogInterface?, _: Int -> }

            val dialog = builder.create()
            dialog.show()
        }
        val BtnSwap : Button = findViewById(R.id.buttonSwap)
        BtnSwap.setOnClickListener {
            val intent = Intent(this, Activity_lab3_2::class.java)
            startActivity(intent)
        }
    }
}