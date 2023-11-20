package com.example.todo

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.ui.theme.TODOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                var textfield by remember { mutableStateOf("") }
                var tableau by remember { mutableStateOf(emptyList<String>()) }

                Text(text = "--TodoList--", modifier = Modifier.align(CenterHorizontally), color = Color.Blue  )
                Text(text = "Ajoutez votre rappel", modifier = Modifier.padding())

                TextField(value = textfield, onValueChange = {textfield = it})

                Button(onClick = {
                    if (textfield != ""){ //Affiche à condition que textfield n'est pas vide
                        tableau = tableau + textfield
                        textfield = ""
                    }
                }) {
                    Row{
                        Text(text = "Cliquez sur moi", modifier = Modifier.padding())
                    }}

                LazyColumn{
                    items(tableau.size) { index ->
                        Text(text = tableau[index])
                        Button(onClick = {
                            tableau = tableau - tableau[index]
                            textfield = ""
                        }) {
                            Row{
                                Text(text = "Delete", modifier = Modifier.padding(), color= Color.Cyan)

                            }}
                    }
                }

            }
            }
            }



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TODOTheme {
        Greeting("Android")
    }
}
}