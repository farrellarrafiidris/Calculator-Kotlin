package com.farrell.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    lateinit var hasil : TextView


    companion object {
        const val RESULT = "Kosong"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        hasil = findViewById(R.id.tv_result2)


        val result = intent.getStringExtra(RESULT)

        hasil.text = result

    }
}