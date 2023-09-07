package com.farrell.mycalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.farrell.mycalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var result : TextView
    private lateinit var back : Button
    private lateinit var binding : ActivityResultBinding


    companion object {
        const val RESULT = "Result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        result = binding.tvResult2
        back = binding.btnBack


        val data = intent.getStringExtra(RESULT)

        result.text = data

        back.setOnClickListener{
            intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
        }

    }
}