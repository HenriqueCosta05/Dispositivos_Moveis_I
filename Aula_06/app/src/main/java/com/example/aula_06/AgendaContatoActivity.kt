package com.example.aula_06

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class AgendaContatoActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        val URL_BASE = "https://console.firebase.google.com/project/fatec-pdm-i/database/fatec-pdm-i-default-rtdb/data/~2F?hl=pt"
        //Setup inicial do método onCreate, responsável por inicializar a aplicação.
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)

        //Puxa os campos do formulário
        val nome = findViewById<EditText>(R.id.edt_nome)
        val email = findViewById<EditText>(R.id.edt_email)
        val telefone = findViewById<EditText>(R.id.edt_telefone)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)
        val client = OkHttpClient()

        //Prepara o JSON
        val contato = Contato(
            nome = nome.text.toString(),
            email = email.text.toString(),
            telefone = telefone.text.toString()
        )

        //Setup do GSON
        val gson = Gson()

        //Personalizando o evento de clique para pesquisa
        btnGravar.setOnClickListener{
            contato
            val contatoResult = gson.toJson(contato)
            val request = Request.Builder()
                .url("$URL_BASE/contatos.json")
                .post(contatoResult.toRequestBody(
                    "application/json".toMediaType()
                )).build()

            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread{
                        Toast.makeText(this@AgendaContatoActivity, "Deu erro, seu queridinho: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread{
                        Toast.makeText(this@AgendaContatoActivity, "Deu tudo certo! Contato cadastrado.", Toast.LENGTH_LONG).show()
                    }
                }
            }
            client.newCall((request)).enqueue(response)
        }
        btnPesquisar.setOnClickListener{
            val request = Request.Builder()
                .url("${URL_BASE}/contatos.json")
                .get()
                .build()

            val response = object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                   runOnUiThread{
                       Toast.makeText(this@AgendaContatoActivity, "Deu erro, seu queridinho: ${e.message}", Toast.LENGTH_LONG).show()
                   }
                }

                override fun onResponse(call: Call, response: Response) {
                    val contatosJson = response.body?.string()
                    val contatos : HashMap<String?, Contato?> = gson.fromJson(contatosJson, HashMap<String?, Contato?>()::class.java)

                    for (contato in contatos.values) {
                        Log.d("Agenda", "Contato: $contato")
                        if(contato != null) {
                            runOnUiThread {
                                nome.setText(contato.nome)
                                email.setText(contato.email)
                                telefone.setText(contato.telefone)
                            }
                        }
                    }
                }
            }
            client.newCall((request)).enqueue(response)
        }
    }
}