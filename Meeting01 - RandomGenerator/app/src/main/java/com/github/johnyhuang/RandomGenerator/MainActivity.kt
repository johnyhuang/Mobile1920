package com.github.johnyhuang.RandomGenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

//    val resultText: TextView = findViewById(R.id.result_text)
//    val rollButton: Button = findViewById(R.id.roll_button)
    lateinit var resultText: TextView
    lateinit var rollButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.result_text) as TextView
        rollButton = findViewById(R.id.flip_button) as Button
        rollButton.setOnClickListener {
            flipDice()
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun flipDice() {
        val randomCoinInt = Random().nextInt(2)
        if (randomCoinInt.equals(0)) {
            resultText.text = "Heads"
        } else {
            resultText.text = "Tails"
        }
    }


}
