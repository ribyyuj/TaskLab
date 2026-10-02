package com.example.tasklab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var tarefa by remember {
        mutableStateOf("")
    }

    var descricao by remember {
        mutableStateOf("")
    }

    var importante by remember {
        mutableStateOf(false)
    }

    var mensagem by remember {
        mutableStateOf("")
    }

    val listaTarefas = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 247, 229))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.lista_tarefa),
            contentDescription = "Logo da Lista de Tarefas",
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "Lista de Tarefas",
            fontSize = 32.sp,
            color = Color(89, 72, 62),
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Organize suas atividades",
            fontSize = 20.sp,
            color = Color(132, 96, 98)
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        OutlinedTextField(
            value = tarefa,
            onValueChange = {
                tarefa = it
            },
            label = {
                Text("Nome da tarefa")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = descricao,
            onValueChange = {
                descricao = it
            },
            label = {
                Text("Descrição da tarefa")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = importante,
                onCheckedChange = {
                    importante = it
                }
            )

            Text(
                text = "Tarefa importante",
                color = Color(89, 72, 62)
            )
        }

        Button(
            onClick = {

                if (tarefa.isEmpty() || descricao.isEmpty()) {

                    mensagem = "Preencha os campos!"

                } else {

                    if (importante) {

                        listaTarefas.add(
                            "⭐ $tarefa\n$descricao"
                        )

                    } else {

                        listaTarefas.add(
                            "$tarefa\n$descricao"
                        )
                    }

                    mensagem = "Tarefa adicionada!"

                    tarefa = ""
                    descricao = ""
                    importante = false
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Adicionar tarefa"
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = mensagem,
            color = Color(132, 96, 98),
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Minhas tarefas",
            fontSize = 22.sp,
            color = Color(89, 72, 62),
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(listaTarefas) { tarefaSalva ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = tarefaSalva,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 17.sp,
                        color = Color(89, 72, 62)
                    )
                }
            }
        }
    }
}