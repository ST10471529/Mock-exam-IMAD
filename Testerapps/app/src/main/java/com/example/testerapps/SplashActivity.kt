package com.example.testerapps

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.`activity_splash.xml`)

        val appname = findViewById<TextView>(R.id.app_name)
        val myname = findViewById<TextView>(R.id.my_name)
        val mystudentnumber = findViewById<TextView>(R.id.my_student_number)
        val gotomainbutton = findViewById<Button>(R.id.go_to_main_button)
        val exitbutton = findViewById<Button>(R.id.exit_button)

        appnameText.text = "Weather App"
        mynameText.text = "Your Name"
        mystudentnumberText.text = "Your Student Number"

        gotomainbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        exitbutton.setOnClickListener {
            finish()
    }

        logo.setImageResource(R.drawable.ic_launcher_foreground)
}