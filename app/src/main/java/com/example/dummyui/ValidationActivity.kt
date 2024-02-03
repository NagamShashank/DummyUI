package com.example.dummyui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.dummyui.databinding.ActivityValidationBinding
import kotlinx.coroutines.flow.combineTransform

class ValidationActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivityValidationBinding
    private var checkName = false
    private var checkPassword = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValidationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.validBtn.isEnabled = false
        validation()
        
    }


    
    fun validation(){

        binding.nameEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val string = p0.toString()
                checkName(string)
                btnEnable()
            }

        })

        binding.passwordEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val string = p0.toString()
                checkPassword(string)
                btnEnable()
            }

        })
    }

    fun checkName(name : String){
        checkName = if (name.isEmpty()){
            binding.validBtn.setBackgroundColor(resources.getColor(R.color.grey))
            false
        }else {
            true
        }
    }

    fun checkPassword(password : String){
        checkPassword = if (password.isEmpty()){
            binding.validBtn.setBackgroundColor(resources.getColor(R.color.grey))
            false

        }else {
            true
        }
    }

    fun btnEnable(){
        binding.validBtn.isEnabled = checkName && checkPassword
        binding.validBtn.setBackgroundColor(resources.getColor(R.color.yellow))
        binding.validBtn.setOnClickListener {
            Toast.makeText(this,"Valid Clicked",Toast.LENGTH_SHORT).show()
        }
    }
}