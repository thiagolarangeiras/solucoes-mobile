package com.example.placardigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.placardigital.ui.theme.PlacarDigitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val inter = Score("Inter", 0)
        val gremio = Score("Gremio", 0)
        setContent {
            ScoreView(inter, gremio);
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Teste() {
    var count by remember { mutableStateOf(0) } ;
    Column {
        Button(onClick = { count++ }) { Text("+") }
        Text("$count")
    }


}