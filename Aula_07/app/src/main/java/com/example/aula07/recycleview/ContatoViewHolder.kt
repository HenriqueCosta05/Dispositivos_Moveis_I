package com.example.aula07.recycleview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aula07.R

class ContatoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    var txtNome : TextView = itemView.findViewById(R.id.edt_nome)
    var txtEmail : TextView = itemView.findViewById(R.id.edt_email)
    var txtTelefone : TextView = itemView.findViewById(R.id.edt_telefone)
}