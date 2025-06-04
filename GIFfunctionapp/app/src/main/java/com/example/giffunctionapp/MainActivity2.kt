package com.example.giffunctionapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.system.exitProcess

class Gif : AppCompatActivity() {

    private var health = 100
    private var hunger = 0
    private var clean = 100


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gif)



        val Pikachu: ImageView = findViewById(R.id.Pikachu)
        val BtnFeed: Button = findViewById(R.id.BtnFeed)
        val BtnBath: Button = findViewById(R.id.BtnBath)
        val BtnPlay: Button = findViewById(R.id.BtnPlay)
        val BtnReset: Button = findViewById(R.id.BtnReset)
        val BtnExit: Button = findViewById(R.id.BtnExit)
        val BtnHome: Button = findViewById(R.id.BtnHome)


        Glide.with(this)
            .load(R.drawable.pikachu)
            .into(Pikachu)

        BtnFeed.setOnClickListener {
            Pikachu.setImageDrawable(null)
            Glide.with(this)
                .asGif()
                .load(R.drawable.eatingpikachu)
                .into(Pikachu)
            feedPet()
        }

        BtnBath.setOnClickListener {
            Pikachu.setImageDrawable(null)
            Glide.with(this)
                .asGif()
                .load(R.drawable.bathingpikachu)
                .into(Pikachu)
            bathPet()
        }

        BtnPlay.setOnClickListener {
            Pikachu.setImageDrawable(null)
            Glide.with(this)
                .asGif()
                .load(R.drawable.happypikachu)
                .into(Pikachu)
            playPet()
        }



        BtnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        updateStatusText()

        reset()

        BtnReset.setOnClickListener {
            Pikachu.setImageDrawable(null)
            Glide.with(this)
                .asGif()
                .load(R.drawable.pikachu)
                .into(Pikachu)
            reset()
        }

        BtnHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun feedPet() {
        hunger -= 20
        if (hunger < 0) hunger = 0
        health += 10
        if (health > 100) health = 100
        updateStatusText()
    }

    private fun bathPet() {
        clean = 100
        health += 5
        if (health > 100) health = 100
        updateStatusText()
    }

    private fun playPet() {
        health -= 10
        if (health < 0) health = 0
        hunger += 20
        if (hunger > 100) hunger = 100
        clean -= 10
        if (clean < 0) clean = 0
        updateStatusText()
    }

    private fun updateStatusText() {
        val statusText: TextView = findViewById(R.id.TextDisplay)
        statusText.text = "Health: $health Hunger: $hunger Clean: $clean"
        statusText.invalidate()
    }

    private fun reset() {
        val statusText: TextView = findViewById(R.id.TextDisplay)
        statusText.text = "Health: 100 Hunger: 0 Clean: 100"
        statusText.invalidate()
    }

}