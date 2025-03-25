package com.example.placardigital

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Score (
    teamName: String,
    teamScore: Int,
) {
    var teamName by mutableStateOf(teamName)
    var teamScore by mutableStateOf(teamScore)
}


//@Preview
@Composable
fun TeamScore(score: Score){
    //var pontos by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text("${score.teamName}", fontSize = 40.sp)
        Button(onClick = { score.teamScore++ }, ) {
            Text("+", fontSize = 40.sp)
        }
        Text("${score.teamScore}", modifier = Modifier.padding(16.dp))
        Button(onClick = { score.teamScore-- }) {
            Text("-", fontSize = 40.sp)
        }
    }
}

@Composable
fun ScoreView(score1: Score, score2: Score){

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        TeamScore(score1)
        TeamScore(score2)
    }
}