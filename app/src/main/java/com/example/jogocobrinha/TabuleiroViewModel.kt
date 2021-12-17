package com.example.jogocobrinha

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jogocobrinha.Cobra




class TabuleiroViewModel : ViewModel() {

    private var _gameStatus = MutableLiveData<Boolean>(
        false
    )
    var gameStatus: LiveData<Boolean> = _gameStatus


    private var _pontos = MutableLiveData<Int>(
        0
    )
    var pontos: LiveData<Int> = _pontos


    private var _velocidade = MutableLiveData<Int>(
        1 // verificar qual o valor de timeout as threads milisegundos
    )
    var velocidade: LiveData<Int> = _velocidade

    private var _row = MutableLiveData<Int>(10)

    var row: LiveData<Int> = _row

    private var _column = MutableLiveData<Int>(10)
    var column: LiveData<Int> = _column


    private var _tabuleiro = MutableLiveData(
        Array(row.value!!) { kotlin.arrayOfNulls<ImageView>(column.value!!) }
    )
    var tabuleiro: LiveData<Array<Array<ImageView?>>> = _tabuleiro

    private var _listPosicaoCobra = MutableLiveData(
        mutableListOf<Cobra>()
        // {0;0} eh a posicao inicial da cobra ou seja o indice 0 da minha lista de Arrays de inteiros
    )

    //var cobra = Cobra(5,5)

    var listPosicaoCobra: LiveData<MutableList<Cobra>> = _listPosicaoCobra


    //----------------------------------FUNCTIONS-------------------------------------//

    public fun cobraMovimento(_listPosicaoCobra : MutableList<Cobra>, tecla : Int ) {
        when(tecla){
            //cima
            1 -> _listPosicaoCobra[0].x = _listPosicaoCobra[0].x - 1
            //baixo
            2 -> _listPosicaoCobra[0].x = _listPosicaoCobra[0].x + 1
            //esquerda
            3 -> _listPosicaoCobra[0].y = _listPosicaoCobra[0].y - 1
            //direita
            4 -> _listPosicaoCobra[0].y = _listPosicaoCobra[0].y + 1
        }

    }


    public fun cobraAdd(pos: Cobra) {
        _listPosicaoCobra.value!!.add(pos)
    }


    // colocar essa funcoes na viewModel de configuracoes
    public fun alterarTabuleiro(row: Int, column: Int) {
        _row.value = row
        _column.value = column
    }

    public fun alterarDificuldade(valorVelocidade: Int) {
        _velocidade.value = valorVelocidade
    }


}
