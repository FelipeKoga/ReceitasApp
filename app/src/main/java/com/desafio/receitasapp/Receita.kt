package com.desafio.receitasapp

import java.io.Serializable

data class Receita (
    var nomeReceita: String,
    var qntCarne: Int,
    var qntLeite: Int,
    var qntFarinha: Int,
    var qntOvo: Int
) : Serializable