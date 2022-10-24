package com.estudos.recyclerview.model

class Filme(
    val titulo: String = "",
    val genero: String = "",
    val ano: String = ""
){

    fun makeData(): ArrayList<Filme> {
        val filmes = ArrayList<Filme>()

        filmes.add(Filme("Homem de Ferro","Aventura", "2008"))
        filmes.add(Filme("Homem de Ferro 2","Aventura", "2010"))
        filmes.add(Filme("Thor","Aventura", "2011"))
        filmes.add(Filme("Capitão América: O Primeiro Vingador","Aventura", "2011"))
        filmes.add(Filme("Os Vingadores","Aventura", "2012"))
        filmes.add(Filme("Homem de Ferro 3","Aventura", "2013"))
        filmes.add(Filme("Thor: O Mundo Sombrio","Aventura", "2013"))
        filmes.add(Filme("Capitão América: Soldado Invernal","Aventura", "2014"))
        filmes.add(Filme("Guardiões da Galáxia","Aventura", "2014"))
        filmes.add(Filme("Vingadores: Era de Ultron","Aventura", "2015"))
        filmes.add(Filme("Homem-Formiga","Aventura", "2015"))

        return  filmes
    }
}