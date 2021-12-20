package com.example.jogocobrinha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jogocobrinha.databinding.ActivityConfiguracaoBinding
import com.example.jogocobrinha.databinding.ActivityResultadoBinding

class Configuracao : AppCompatActivity() {

    lateinit var binding: ActivityConfiguracaoBinding

    lateinit var viewModel: ConfiguracaoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_configuracao)
        viewModel = ViewModelProvider(this).get(ConfiguracaoViewModel::class.java)

        var i = Intent(this, Tabuleiro::class.java)
        var b = Bundle()


        binding.salvarCfg.setOnClickListener {
            if(binding.radioButtonFacil.isSelected){
                b.putLong("DIFICULDADE", 1000)
            }else if (binding.radioButtonMedio.isSelected){
                b.putLong("DIFICULDADE", 1000/2)
            }else if (binding.radioButtonDificil.isSelected){
                b.putLong("DIFICULDADE", 1000/4)
            }

            if (binding.radioButton24x24.isSelected){
                b.putInt("TAMANHO_TABULEIRO", 24)

            }else if (binding.radioButton48x48.isSelected){
                b.putInt("TAMANHO_TABULEIRO", 48)
            }

            intent.putExtras(b)
            startActivity(i)
        }

    }
}