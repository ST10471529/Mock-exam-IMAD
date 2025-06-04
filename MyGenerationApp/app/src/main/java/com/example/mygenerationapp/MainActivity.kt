package com.example.generationsapp

    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.TextView
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity

    class MainActivity : AppCompatActivity() {

        private var year : EditText? = null
        private var genTxt : TextView? = null


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)


            yearInput= findViewById(R.id.yearInput)
            genTxt = findViewById(R.id.genTxt)

            val button = findViewById<Button>(R.id.button)


            button.setOnClickListener() {
                checkgeneration()
            }


        }
        private fun checkgeneration(){
            when(year?.text.toString().trim().toInt()){

                in 1901..1924 -> genTxt?.text = "The Greatest Generation"
                in 1925..1945 -> genTxt?.text = "The Silent Generation"
                in 1946..1964 ->genTxt?.text = "The Baby Boomers"
                in 1965..1980 -> genTxt?.text = "Generation X"
                in 1981..1994 -> genTxt?.text = "Millennials"
                in 1995..2012 -> genTxt?.text = "Generation Z"
                in 2013..2025 ->genTxt?.text = "Generation Alpha"

                else ->{
                    genTxt?.text = "Alien! ( our Birth Year is Invalid )"
                }
            }
        }
    }
}