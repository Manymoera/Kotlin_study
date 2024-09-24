package com.example.first_app_1

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class animation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animation)

        val view_square = findViewById<View>(R.id.view2)

        ObjectAnimator.ofFloat(view_square, "translationY", 1500f).apply {
            duration = 2000
            start()
        }
        view_square.animate()
            .scaleY(4f)
            .scaleX(4f)
            .duration = 2000
    }
}