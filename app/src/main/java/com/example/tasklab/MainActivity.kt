package com.example.tasklab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Row
import com.example.tasklab.ui.theme.TaskLabTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TaskLabTheme {
                Menu()
            }
        }
    }
}

@Composable
fun Menu() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255,  247, 229 )),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.spacedBy(
            space = 15.dp,
            alignment = Alignment.CenterVertically
        )
    ) {

        Image(
            painter = painterResource(id = R.drawable.lista_tarefa), // Nome do seu arquivo na pasta drawable
            contentDescription = "Logo do Aplicativo",           // Descrição para acessibilidade
            modifier = Modifier.size(200.dp)                     // Define o tamanho do logo
        )

        Text(
            text = "Lista De Tarefa",
            fontSize = 39.sp,
            color = Color(89, 72, 62),
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Organizando sua vida",
            fontSize = 25.sp,
            color = Color(132, 96, 98),
            fontWeight = FontWeight.Light
        )


    }
}