package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private var number1: EditText? = null
    private var number2: EditText? = null
    private var answer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        answer = findViewById(R.id.answer)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnSq = findViewById<Button>(R.id.btnSq)
        val btnPow = findViewById<Button>(R.id.btnPow)
        val btnStat = findViewById<Button>(R.id.btnStat)

        // Set listeners for buttons
        btnAdd.setOnClickListener {
            add()
        }
        btnSub.setOnClickListener {
            subtract()
        }
        btnMul.setOnClickListener {
            multiply()
        }
        btnDiv.setOnClickListener {
            divide()
        }
        btnSq.setOnClickListener {
            squareRoot()
        }
        btnPow.setOnClickListener {
            power()
        }
        btnStat.setOnClickListener {
            val intent = Intent(this, Stats::class.java)
            startActivity(intent)
        }


    }

    // Function to perform addition
    @SuppressLint("SetTextI18n")
    private fun add() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = input1.add(input2).toString()
        }
    }

    // Function to perform subtraction
    @SuppressLint("SetTextI18n")
    private fun subtract() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = input1.subtract(input2).toString()
        }
    }

    // Function to perform multiplication
    @SuppressLint("SetTextI18n")
    private fun multiply() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = input1.multiply(input2).toString()
        }
    }

    // Function to perform division
    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    private fun divide() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            // Check for division by zero
            if (input2.compareTo(BigDecimal.ZERO) == 0) {
                number2?.error = "Cannot divide by zero"
            } else {
                answer?.text = input1.divide(input2, 2, RoundingMode.HALF_UP).toString()
            }
        }
    }

    // Function to check if inputs are not empty
    private fun inputIsNotEmpty(): Boolean {
        var isValid = true
        // Check if first number is empty
        if (number1?.text.toString().trim().isEmpty()) {
            number1?.error = "Required"
            isValid = false
        }
        // Check if second number is empty
        if (number2?.text.toString().trim().isEmpty()) {
            number2?.error = "Required"
            isValid = false
        }
        return isValid
    }

    // Function to calculate square root of the first number
    @SuppressLint("SetTextI18n")
    private fun squareRoot() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            // Calculate square root
            val result = sqrt(input1.toDouble())
            answer?.text = result.toString()
        }
    }

    // Function to perform power operation (first number raised to the power of second number)
    @SuppressLint("SetTextI18n")
    private fun power() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            // Compute power
            val result = input1.pow(input2.toInt())
            answer?.text = result.toString()
        }
    }
}
