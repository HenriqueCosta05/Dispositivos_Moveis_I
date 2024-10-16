package com.example.exercicio_calculadora_composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Calculadora() {
        val nomeBotoes = listOf(
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            ".", "0", "=", "/"
        )
        Column() {
            Row {
                OutlinedTextField(value = "", onValueChange = {},
                    placeholder = { Text("Números", fontSize = 12.sp) })
                Button(onClick = {}) {
                    Text("CE", fontSize = 28.sp)
                }
            }
            for(linha in 0 .. 3) {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                // Itera sobre os elementos de nomeBotoes
                for(coluna in 0 .. 3) {
                    Button(onClick = {}) {
                        val indice = linha * 4 + coluna
                        val texto = nomeBotoes[indice]
                        Text(texto, fontSize = 28.sp)
                    }
                    }
                }
            }
        }
    }
}