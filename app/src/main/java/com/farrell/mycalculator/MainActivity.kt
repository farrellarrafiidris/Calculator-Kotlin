package com.farrell.mycalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.farrell.mycalculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var edtLength  : TextInputLayout
    private lateinit var edtWidth   : TextInputLayout
    private lateinit var edtHeight  : TextInputLayout
    private lateinit var btnResult  : Button
    private lateinit var binding    : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView (binding.root)

        edtLength   = binding.edtLength
        edtWidth    = binding.edtWidth
        edtHeight   = binding.edtHeight
        btnResult   = binding.btnResult

        btnResult.setOnClickListener(this)

    }
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_result->{
                val getLength = edtLength.editText?.text.toString().trim()
                val getWidth = edtWidth.editText?.text.toString().trim()
                val getHeight = edtHeight.editText?.text.toString().trim()
                val msg = "This field is required"
                if (getLength.isEmpty()) {
                    edtLength.error = msg
                    return
                }
                if (getWidth.isEmpty()) {
                    edtWidth.error = msg
                    return
                }
                if (getHeight.isEmpty()) {
                    edtHeight.error = msg
                    return
                }
                val result =
                    getLength.toDouble() * getWidth.toDouble() * getHeight.toDouble()

                val intent = Intent(this@MainActivity,ResultActivity::class.java)
                intent.putExtra(ResultActivity.RESULT,result.toString())
                startActivity(intent)

            }
        }
    }
}