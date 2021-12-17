package com.example.jogocobrinha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jogocobrinha.databinding.ActivityTabuleiroBinding

class Tabuleiro : AppCompatActivity() {

    //shared preferences
    //coroutinas
    //botao continuar aparece quando o estado for pausado
    //viewModel

    lateinit var binding: ActivityTabuleiroBinding
    lateinit var viewModel: TabuleiroViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tabuleiro)
        viewModel = ViewModelProvider(this).get(TabuleiroViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val inflater = LayoutInflater.from(this)


        viewModel.listPosicaoCobra.value!!.add(Ponto(5, 5))
        viewModel.listPosicaoCobra.value!!.add(Ponto(4, 5))
        viewModel.listPosicaoCobra.value!!.add(Ponto(3, 5))
        //viewModel.listPosicaoCobra.value!!.add(Ponto(5,4))

        loadTabuleiro(inflater)

        runGame()

        binding.buttonMoverCima.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 1)
                binding.gridLayout.removeAllViews()
            }
        }
        binding.buttonMoverBaixo.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 2)
                binding.gridLayout.removeAllViews()
            }
        }
        binding.buttonMoverEsquerda.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 3)
                binding.gridLayout.removeAllViews()
            }
        }
        binding.buttonMoverDireita.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 4)
                binding.gridLayout.removeAllViews()
            }
        }
    }

    fun runGame() {
        Thread {
            while (true) {
                Thread.sleep(1000)
                runOnUiThread {
                    limpaTabuleiro()
                    printCobra()
                    moveCobra()
                }
            }
        }.start()
    }


    private fun moveCobra(){
        for (i in 0 until viewModel.listPosicaoCobra.value!!.size) {
            viewModel.listPosicaoCobra.value!!.get(i).y = viewModel.listPosicaoCobra.value!!.get(i).y + 1
        }
    }

    private fun printCobra() {
        for (i in 0 until viewModel.listPosicaoCobra.value!!.size) {
            viewModel.tabuleiro.value!![viewModel.listPosicaoCobra.value!!.get(i).x][viewModel.listPosicaoCobra.value!!.get(
                i
            ).y]!!.setImageResource(R.drawable.corpo_cobra)
        }
    }

    private fun limpaTabuleiro() {
        for (i in 0 until viewModel.row.value!!) {
            for (j in 0 until (viewModel.column.value!!)) {
                viewModel.tabuleiro.value!![i][j]!!.setImageResource(R.drawable.tabuleiro)
            }
        }
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











