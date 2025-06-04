package com.example.letteroflove

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val classText = findViewById<EditText>(R.id.classText)
        val displayText = findViewById<TextView>(R.id.displaytext)
        val findButton = findViewById<Button>(R.id.findButton)

        findButton.setOnClickListener {
            val yearString = classText.text.toString()

            if (yearString.isEmpty()) {
                displayText.text = "Please enter a year."
            } else {
                val year = yearString.toIntOrNull()

                if (year == null) {
                    displayText.text = "Invalid year format."
                } else {
                    val message = when (year) {
                        2024 -> "Best class ever.We brought the vibes regardless of what happend."
                        2020-> "What a crazy Year."
                        2021-> "Who still remembers them."
                        2022-> "Boring year honestly."
                        2023-> "Mehh year."
                        else -> "The correct year is 2024 because we ARE the best year"
                    }
                    displayText.text = message
                }
            }
        }
    }
}