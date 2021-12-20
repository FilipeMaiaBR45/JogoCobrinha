package com.example.jogocobrinha

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultadoViewModel : ViewModel()  {
    private var _pontuacaoFinal = MutableLiveData<Int>(0)
    var pontos: LiveData<Int> = _pontuacaoFinal



    //---------------------FUNCTION-----------------------------------

    fun setPontuacaoFinal(pontuacao : Int){
        _pontuacaoFinal.value = pontuacao!!
    }
}