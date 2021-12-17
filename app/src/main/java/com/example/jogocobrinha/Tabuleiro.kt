package com.example.jogocobrinha

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintProperties.WRAP_CONTENT
import androidx.core.view.children
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

       // viewModel.cobraAdd(Cobra(5, 5))
       // viewModel.cobraAdd(Cobra(5, 4))

        viewModel.listPosicaoCobra.value!!.add(Cobra(5,5))
        //viewModel.listPosicaoCobra.value!!.add(Cobra(5,4))



        var cont = 0
//
//        fun printarTabuleiro(){
//            //montar tabuleiro
//            //var k = 0
//            //var l = 0
//
//            viewModel.listPosicaoCobra.value!!.forEach {
//                for (i in 0..(viewModel.row.value!! - 1)) {
//                    for (j in 0..(viewModel.column.value!! - 1)) {
//                       // Log.i("FOR2", "pos: $i")
//                        if (i == it.x && j == it.y) {
//                            Log.i("COBRA", "0")
//                            val im = inflater.inflate(
//                                R.layout.cobra,
//                                binding.gridLayout,
//                                false
//                            ) as ImageView
//
//                            viewModel.tabuleiro.value!![i][j] = im
//
//                           // binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
//
//
//
//                        } else {
//
//                            Log.i("COBRA", "1")
//                            val im = inflater.inflate(
//                                R.layout.image,
//                                binding.gridLayout,
//                                false
//                            ) as ImageView
//                            viewModel.tabuleiro.value!![i][j] = im
//                            continue
//
//                           // binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
//                        }
//
//                    }
//
//                    }
//                cont++
//                Log.i("FOREACH", "$cont")
//                }
//
//
//
//            for (i in 0..(viewModel.row.value!! - 1)) {
//                Log.i("FOR1", "pos: $i")
//                for (j in 0..(viewModel.column.value!! - 1)) {
//                    binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
//                }
//            }




       // }

        fun printarTabuleiro(){
            //montar tabuleiro
            var k = 0
            var j = 0

            for (i in 0..(viewModel.row.value!! - 1)) {
                Log.i("FOR1", "pos: $i")
                for (j in 0..(viewModel.column.value!! - 1)) {
                    Log.i("FOR2", "pos: $i")
                    viewModel.listPosicaoCobra.value!!.forEach {
                        cont++
                        if (i == it.x && j == it.y) {
                            Log.i("COBRA", "0")
                            val im = inflater.inflate(
                                R.layout.cobra,
                                binding.gridLayout,
                                false
                            ) as ImageView

                            viewModel.tabuleiro.value!![i][j] = im

                            binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])


                        } else {
                            Log.i("COBRA", "1")
                            val im = inflater.inflate(
                                R.layout.image,
                                binding.gridLayout,
                                false
                            ) as ImageView
                            viewModel.tabuleiro.value!![i][j] = im

                            binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
                        }
                        Log.i("FOREACH", "$cont")
                    }
                }
            }


        }

        printarTabuleiro()


//        fun printarTabuleiro(): Unit {
//
//            for (i in 0..(viewModel.row.value!! - 1)) {
//                for (j in 0..(viewModel.column.value!! - 1)) {
//                    viewModel.listPosicaoCobra.value!!.forEach {
//                        if ((i == it.x && j == it.x) && (j == it.y && i == it.y)) {
//                            val im = inflater.inflate(
//                                R.layout.cobra,
//                                binding.gridLayout,
//                                false
//                            ) as ImageView
//
//                            viewModel.tabuleiro.value!![i][j] = im
//
//                            //binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
//
//
//                        } else {
//                            val im = inflater.inflate(
//                                R.layout.image,
//                                binding.gridLayout,
//                                false
//                            ) as ImageView
//                            viewModel.tabuleiro.value!![i][j] = im
//
//                            //binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
//                        }
//
//
//                    }
//
//                    binding.gridLayout.addView(viewModel.tabuleiro.value!![i][j])
//                }
//            }
//        }
//
//        printarTabuleiro()












        binding.buttonMoverCima.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 1)
                binding.gridLayout.removeAllViews()
                printarTabuleiro()


            }
        }
        binding.buttonMoverBaixo.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 2)
                binding.gridLayout.removeAllViews()
                printarTabuleiro()


            }
        }
        binding.buttonMoverEsquerda.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 3)
                binding.gridLayout.removeAllViews()
                printarTabuleiro()


            }
        }
        binding.buttonMoverDireita.setOnClickListener {
            viewModel.listPosicaoCobra.value!!.forEach {
                viewModel.cobraMovimento(viewModel.listPosicaoCobra.value!!, 4)
                binding.gridLayout.removeAllViews()
                printarTabuleiro()


            }
        }


    }
}











