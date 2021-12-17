package com.example.jogocobrinha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jogocobrinha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        var intent = Intent(this, Tabuleiro::class.java)

        binding.buttonNovoJogo.setOnClickListener {
            startActivity(intent)
        }




    }
}