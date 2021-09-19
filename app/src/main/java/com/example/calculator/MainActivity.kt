package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plusButton = findViewById<Button>(R.id.plus_button)
        val minusButton = findViewById<Button>(R.id.minus_button)
        val muliplyButton = findViewById<Button>(R.id.multiply_button)
        val divideButton = findViewById<Button>(R.id.divide_button)

        fun createNewActivity(result: Int){
            val intent = Intent(this, SecondActivity::class.java )
            intent.putExtra("message", result.toString())
            startActivity(intent)
        }

        plusButton.setOnClickListener {
            createNewActivity(getFirstNumber() + getSecondNumber())
        }
        minusButton.setOnClickListener{
            createNewActivity(getFirstNumber() - getSecondNumber())
        }
        muliplyButton.setOnClickListener{
            createNewActivity(getFirstNumber() * getSecondNumber())
        }
        divideButton.setOnClickListener{
            if (getSecondNumber() != 0) {
                createNewActivity(getFirstNumber() / getSecondNumber())
            }
            else Toast.makeText(this, "Undefined", Toast.LENGTH_SHORT).show()
        }



    }

    /** method to get first number if it was entered*/
    private fun getFirstNumber(): Int {
        val firstNumEditText = findViewById<EditText>(R.id.first_num_edit)
        var firstNum = firstNumEditText.text.toString()
        if (firstNum.isNotBlank()) return firstNum.toInt()
        else Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
        return 0
    }

    /** method to get second number if it was entered*/
    private fun getSecondNumber(): Int {
        val secondNumEditText = findViewById<EditText>(R.id.second_num_edit)
        var secondNum = secondNumEditText.text.toString()
        if (secondNum.isNotBlank()) return secondNum.toInt()
        else Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
        return 0
    }





}