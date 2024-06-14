package com.roman.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        // Вставили rolldice вне блока setOnClickListener, чтобы при запуске приложения сразу
        // бросался кубик
        rollDice()
        rollButton.setOnClickListener {

            rollDice()

            //val rollTextView: TextView = findViewById(R.id.textView)
            //
            //val toast = Toast.makeText( this, "Кубики брошены", Toast.LENGTH_LONG)
            //toast.show()
        }

    }
        //Бросок конкретного кубика
        private fun rollDice() {
            val dice = Dice(6)
            val dice2 = Dice(6)
            val kubikRoll = dice.roll()
            val kubikRoll2 = dice2.roll()
            val diceImage: ImageView = findViewById(R.id.imageDice)
            val diceImage2: ImageView = findViewById(R.id.imageDice2)

            // В зависимости от значеняи полученного через random присваиваем картинки к результату

            when(kubikRoll) {
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
            when(kubikRoll2) {
                1 -> diceImage2.setImageResource(R.drawable.dice_1)
                2 -> diceImage2.setImageResource(R.drawable.dice_2)
                3 -> diceImage2.setImageResource(R.drawable.dice_3)
                4 -> diceImage2.setImageResource(R.drawable.dice_4)
                5 -> diceImage2.setImageResource(R.drawable.dice_5)
                6 -> diceImage2.setImageResource(R.drawable.dice_6)
            }

            // if(kubikRoll==1) {
            //} else if(kubikRoll==2) {
            //}

        }

        class Dice(val numSides: Int) {
            fun roll(): Int {
                return (1..numSides).random()
            }
        }
    }
