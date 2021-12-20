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


        var intent1 = Intent(this, Tabuleiro::class.java)
        var intent2 = Intent(this, Configuracao::class.java)


        binding.buttonNovoJogo.setOnClickListener {
            startActivity(intent1)
        }

        binding.buttonConfiguracao.setOnClickListener {
            startActivity(intent2)
        }




    }
}