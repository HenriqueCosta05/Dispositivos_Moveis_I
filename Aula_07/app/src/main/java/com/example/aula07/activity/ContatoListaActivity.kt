package com.example.aula07.activity

import android.app.Activity
import android.os.Bundle
import com.example.aula07.R

class ContatoListaActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_item_layout)
    }
}