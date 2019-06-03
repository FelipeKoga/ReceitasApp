package com.desafio.receitasapp

data class ReceitasDB(
    var receitas: MutableList<Receita> = mutableListOf(
        Receita("Bolinho de carne moída", 500, 2, 2, 2),
        Receita("Bife a Milanesa", 1000, 2, 2, 2),
        Receita("Panqueca de carne moída", 300, 2, 1, 1),
        Receita("Bife empanado", 500, 4, 2, 0),
        Receita("Bolinho de carne de sol", 2000, 5, 1, 2),
        Receita("Bolinho de farinha de trigo", 0, 2, 1, 1),
        Receita("Torta de Carne Moída", 250, 1, 4, 3),
        Receita("Ovos mexidos com bacon", 200, 0, 0, 4),
        Receita("Hamburger caseiro", 500, 0, 2, 1),
        Receita("Farofa de Carne com Ovo", 300, 0, 2, 2)
    )
)
// 2000 2 2 2