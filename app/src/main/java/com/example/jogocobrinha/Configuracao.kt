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
            if(binding.radioButtonFacil.isChecked){
                b.putLong("DIFICULDADE", 1000)
            }else if (binding.radioButtonMedio.isChecked){
                b.putLong("DIFICULDADE", 500)
            }else if (binding.radioButtonDificil.isChecked){
                b.putLong("DIFICULDADE", 250)
            }

            if (binding.radioButton24x24.isChecked){
                b.putInt("TAMANHO_TABULEIRO", 24)

            }else if (binding.radioButton48x48.isChecked){
                b.putInt("TAMANHO_TABULEIRO", 48)
            }

            i.putExtras(b)
            startActivity(i)
        }

    }
}