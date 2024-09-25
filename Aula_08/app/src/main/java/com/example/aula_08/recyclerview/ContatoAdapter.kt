package com.example.aula_08.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aula_08.R
import com.example.aula_08.model.Contato

class ContatoAdapter (val lista : ArrayList<Contato>, val contexto : Context) : RecyclerView.Adapter<ContatoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val inflater = LayoutInflater.from(contexto)
        val view = inflater.inflate(R.layout.contato_item_layout, parent, false)
        val vh = ContatoViewHolder(view)

        return vh
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = lista[position]
        holder.txtNome.text = contato.nome
        holder.txtEmail.text = contato.email
        holder.txtTelefone.text = contato.telefone
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}