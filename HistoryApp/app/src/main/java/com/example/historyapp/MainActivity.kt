package com.example.historyapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var ageText: EditText
    private lateinit var resultAgeText: TextView
    private lateinit var matchButton: Button
    private lateinit var clearButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
            resultAgeText.text = "The age is out of range. Age must be between 20 and 100."
            return
        }

        val matchedPerson = matchAgeToHistoricalFigure(age)
        resultAgeText.text = matchedPerson
    }

    private fun matchAgeToHistoricalFigure(age: Int): String {
        val historicalFigures = mapOf(
            "Elisabeth Waldo" to 106,
            "George Washington" to 105,
            "Thomas Jefferson" to 104,
            "John Quincy Adams" to 103,
            "John Adams" to 102,
            "William H. Webster" to 101,
            "Abraham Lincoln" to 100,
            "Andrew Johnson" to 99,
            "Ian McKellen" to 98,
            "James Stewart" to 97,
            "James Cagney" to 96,
            "William Shatner" to 95,
            "Clint Eastwood" to 94,
            "Gene Hackman" to 93,
            "Jack Nicholson" to 92,
            "James Earl Jones" to 91,
            "Walter Matthau" to 90,
            "Robert Wagnar" to 89,
            "Henry Fonda" to 88,
            "Paul Newman" to 87,
            "Morgan Freeman" to 86,
            "Roy Scheider" to 85,
            "Robert Duvall" to 84,
            "Sean Connery" to 83,
            "Joe Biden" to 82,
            "Bill Clinton" to 81,
            "George H.W. Bush" to 80,
            "Ronald Reagan" to 79,
            "Donald Trump" to 78,
            "George W. Bush" to 77,
            "Jimmy Carter" to 76,
            "Richard Nixon" to 75,
            "Phil Collins" to 74,
            "Bruce Springsteen" to 73,
            "Bob Dylan" to 72,
            "Johnny Cash" to 71,
            "Rowan Atkinson" to 70,
            "Jerry Seinfeld" to 69,
            "Homer Simpson" to 68,
            "Arnold Schwarzenegger" to 67,
            "Sylvester Stallone" to 66,
            "Mike Pence" to 65,
            "Steve Carell" to 64,
            "Tom Hanks" to 63,
            "Harrison Ford" to 62,
            "Michael Jordan" to 61,
            "Roger Federer" to 60,
            "Lionel Messi" to 59,
            "Mike Tyson" to 58,
            "Nicole Kidman" to 57,
            "Angelina Jolie" to 56,
            "Jennifer Lopez" to 55,
            "Sandra Bullock" to 54,
            "Shaquille O'Neal" to 53,
            "Cristiano Ronaldo" to 52,
            "LeBron James" to 51,
            "Kevin Durant" to 50,
            "50 Cent" to 49,
            "Kobe Bryant" to 48,
            "Tom Brady" to 47,
            "Usher" to 46,
            "John Krasinski" to 45,
            "Jennifer Aniston" to 44,
            "Brad Pitt" to 43,
            "Chris Hemsworth" to 41,
            "Robert Downey Jr." to 40,
            "Jennifer Lawrence" to 39,
            "Drake" to 38,
            "Beyoncé" to 37,
            "Katy Perry" to 36,
            "Chris Brown" to 35,
            "Emma Watson" to 34,
            "Justin Bieber" to 33,
            "Harry Styles" to 31,
            "Dakota Fanning" to 30,
            "Dua Lipa" to 29,
            "Camila Cabello" to 28,
            "Selena Gomez" to 27,
            "Zendaya" to 26,
            "Brock Purdy" to 25,
            "Taylor Swift" to 24,
            "Ariana Grande" to 23,
            "Olivia Rodrigo" to 22,
            "Billie Eilish" to 21,

        )
        for ((person, personAge) in historicalFigures) {
            if (age == personAge) {
                return "You matched with $person"
            }
        }
        return "No match found."
    }

    private fun handleClearButtonClick() {
        ageText.text.clear()
        resultAgeText.text = ""
    }
}
