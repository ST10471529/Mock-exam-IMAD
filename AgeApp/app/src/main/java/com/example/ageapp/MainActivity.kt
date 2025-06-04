package com.example.ageapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var ageText: EditText
    private lateinit var resultAgeText: TextView
    private lateinit var matchButton: Button
    private lateinit var clearButton: Button
    private lateinit var exitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageText = findViewById(R.id.ageText)
        resultAgeText = findViewById(R.id.resultAgeText)
        matchButton = findViewById(R.id.matchButton)
        clearButton = findViewById(R.id.clearButton)
        exitButton = findViewById(R.id.exitButton)

        matchButton.setOnClickListener {
            handleMatchButtonClick()
        }
        clearButton.setOnClickListener {
            handleClearButtonClick()
        }
        exitButton.setOnClickListener {
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }
    }

    private fun handleMatchButtonClick() {
        val ageInput = ageText.text.toString()
        if (ageInput.isEmpty()) {
            ageText.error = "Please enter your age."
            resultAgeText.text = "Please enter your age."
            return
        }

        val age = ageInput.toIntOrNull()
        if (age == null) {
            resultAgeText.text = "Invalid age input."
            return
        }

        if (age < 20 || age > 100) {
            resultAgeText.text = "The age is our of range. Age must be between 20 and 100."
            return
        }

        val matchedPerson = matchAgeToHistoricalFigure(age)
        resultAgeText.text = matchedPerson
        }

         private fun matchAgeToHistoricalFigure(age: Int): String {
            val historicalFigures = mapOf(
                "O.J.Simpson" to 120,
                "Obi-Wan Kenobi" to 57,
                "Homer Simpson" to 40,
                // Add more historical figures and their ages here
            )

            for ((person, personAge) in historicalFigures) {
                if (age == personAge) {
                    return " You matched with $person"
                }
            }

            return "No match found."
        }

private fun handleClearButtonClick() {
    }
}
