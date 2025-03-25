package com.example.atividade3_calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalRuler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atividade3_calculadora.ui.theme.Atividade3calculadoraTheme
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Calculadora()
        }
    }
}

class Texto ( texto: String) {
    var texto by mutableStateOf(texto)
}

fun calcular(s: String): String {
    val a = ExpressionBuilder(s).build()
    return a.evaluate().toInt().toString()
}

fun addChar(texto: Texto, newChar: String){
    if (newChar == "C") {
        texto.texto = ""
        return;
    }
    if (newChar == "=") {
        try {
            val result = calcular(texto.texto)
            texto.texto = result;
        } catch (e: Exception) {
            texto.texto = "";
        }
        return;
    }
    texto.texto += newChar
}


@Preview(showBackground = true)
@Composable
fun Calculadora(){
    val texto = Texto("")
    val botao = listOf(
        listOf("1", "4", "7", "C"),
        listOf("2", "5", "8", "0"),
        listOf("3", "6", "9", "="),
        listOf("+", "-", "*", "/"),
    )
    Teclado(botao, texto)
}

@Composable
fun Teclado(botao: List<List<String>>, texto: Texto){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(texto.texto, fontSize = 40.sp)
        HorizontalDivider(
            color = Color.Gray,
            thickness = 5.dp,
            modifier = Modifier.fillMaxWidth() // Adjust width as needed
        )
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            TecladoLinha(botao[0], texto)
            TecladoLinha(botao[1], texto)
            TecladoLinha(botao[2], texto)
            TecladoLinha(botao[3], texto)
        }
    }
}

@Composable
fun TecladoLinha(botao: List<String>, texto: Texto){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
    )  {
        Button(onClick = { addChar(texto, botao[0]) } ) {
            Text("${botao[0]}", fontSize = 40.sp)
        }
        Button(onClick = { addChar(texto, botao[1]) } ) {
            Text("${botao[1]}", fontSize = 40.sp)
        }
        Button(onClick = { addChar(texto, botao[2]) } ) {
            Text("${botao[2]}", fontSize = 40.sp)
        }
        Button(onClick = { addChar(texto, botao[3]) } ) {
            Text("${botao[3]}", fontSize = 40.sp)
        }
    }
}