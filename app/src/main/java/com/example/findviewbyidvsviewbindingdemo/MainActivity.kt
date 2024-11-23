package com.example.findviewbyidvsviewbindingdemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textViewMainCounter: TextView
    lateinit var buttonMainIncrement: Button

    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        wireWidgets()
        setListeners()
    }

    private fun setListeners() {
        buttonMainIncrement.setOnClickListener {
            score++
            textViewMainCounter.text = "Score: $score"
        }
    }

    private fun wireWidgets() {
        textViewMainCounter = findViewById(R.id.textView_main_counter)
        buttonMainIncrement = findViewById(R.id.button_main_increment)
    }
}