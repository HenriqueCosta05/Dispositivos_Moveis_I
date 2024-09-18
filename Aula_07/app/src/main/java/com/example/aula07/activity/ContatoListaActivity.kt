package com.example.aula07.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aula07.R
import com.example.aula07.R.*
import com.example.aula07.model.Contato
import com.example.aula07.recycleview.ContatoAdapter

class ContatoListaActivity : Activity() {

    val lista = ArrayList<Contato>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(layout.contato_lista_activity)
        lista.add(Contato("João Silva", "(11) 11111", "Joao@tete.com"))
        lista.add(Contato("Jose Silva", "(11) 11111", "Maria@tete.com"))
        lista.add(Contato("Maria Silva", "(11) 11111", "Jose@tete.com"))

        val adapter = ContatoAdapter(this, lista)
        val recycler = findViewById<RecyclerView>(R.id.rcv_contato_lista)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }
}