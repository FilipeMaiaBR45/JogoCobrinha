package com.example.jogocobrinha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jogocobrinha.databinding.ActivityTabuleiroBinding

class Tabuleiro : AppCompatActivity() {

    lateinit var binding: ActivityTabuleiroBinding
    lateinit var viewModel: TabuleiroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tabuleiro)
        viewModel = ViewModelProvider(this).get(TabuleiroViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val inflater = LayoutInflater.from(this)

        var i = Intent(this, Resultado::class.java)
        //var intent2 = Intent(this, MainActivity::class.java)



        val params = intent.extras
        var dificuldade  = params?.getLong("DIFICULDADE", 1000)
        Log.i("DIFICULDADE", "$dificuldade")
        var tamanho_tabuleiro =  params?.getInt("TAMANHO_TABULEIRO", 48)
        Log.i("TAM_TABULEIRO", "$tamanho_tabuleiro")

        if(dificuldade == null){
            dificuldade = 1000
        }

        if(tamanho_tabuleiro == null){
            tamanho_tabuleiro = 48
        }

        //viewModel.alterarDificuldade(dificuldade)
        //viewModel.alterarTabuleiro(tamanho_tabuleiro , tamanho_tabuleiro)


        viewModel.mudarMovimento(4)

       // viewModel.limpaTabuleiro()

        loadTabuleiro(inflater)

        viewModel.starGame(tamanho_tabuleiro, tamanho_tabuleiro)


        runGame(i, dificuldade)






        binding.buttonMoverCima.setOnClickListener {
            viewModel.mudarMovimento(1)
        }
        binding.buttonMoverBaixo.setOnClickListener {
            viewModel.mudarMovimento(2)
        }
        binding.buttonMoverEsquerda.setOnClickListener {
            viewModel.mudarMovimento(3)
        }
        binding.buttonMoverDireita.setOnClickListener {
            viewModel.mudarMovimento(4)
        }

        binding.imageButtonPause.setOnClickListener {
           // startActivity(intent2)
        }

    }


    fun runGame(intent : Intent, dificuldade : Long) {

        Thread {
            while (viewModel.gameStatus.value!! == true) {
                Thread.sleep(viewModel.velocidade.value!!)
                runOnUiThread {
                    viewModel.limpaTabuleiro()

                    viewModel.printFruta(viewModel.posicaoFrutaLinha.value!!, viewModel.posicaoFrutaColuna.value!!)
                    viewModel.comeuFruta(viewModel.posicaoFrutaLinha.value!!, viewModel.posicaoFrutaColuna.value!!)
                    viewModel.gameOver()
                    viewModel.refreshCobra()
                    viewModel.printCobra()
                    viewModel.moveCobra(viewModel.direcao.value!!)
                }
            }

            var b = Bundle()
            b.putString("PONTOS", viewModel.pontos.value!!.toString())
            intent.putExtras(b)
            startActivity(intent)
        }.start()

    }

    private fun loadTabuleiro(inflater: LayoutInflater) {
        for (i in 0..(viewModel.row.value!! - 1)) {
            Log.i("FOR1", "pos: $i")
            for (j in 0..(viewModel.column.value!! - 1)) {
                Log.i("FOR2", "pos: $i")
                val im = inflater.inflate(
                    R.layout.cobra,
                    binding.gridLayout,
                    false
                ) as ImageView
                viewModel.tabuleiro.value!![i][j] = im
                binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
            }
        }
    }











}











