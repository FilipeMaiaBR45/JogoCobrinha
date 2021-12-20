package com.example.jogocobrinha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jogocobrinha.databinding.ActivityResultadoBinding
import com.example.jogocobrinha.databinding.ActivityTabuleiroBinding

class Resultado : AppCompatActivity() {

    lateinit var binding: ActivityResultadoBinding
    lateinit var viewModel: ResultadoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_resultado)
        viewModel = ViewModelProvider(this).get(ResultadoViewModel::class.java)




        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val params = intent.extras
        val pontos = params?.getString("PONTOS")
        Log.i("PONTOSRESULT", "$pontos")

        binding.pontucaoFimDeJogo.text = pontos

        binding.buttonReiniciarJogo.setOnClickListener {
            var i = Intent(this, Tabuleiro::class.java)
            startActivity(i)
        }

        binding.buttonSairResultado.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }






    }
}