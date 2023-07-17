package com.ereyes.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.ereyes.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val messages: MutableList<Message> = mutableListOf()
                    messages.add(Message("Lexi", "Esto es una prueba para visualizar un "))
                    messages.add(Message("Lexi", "Prueba "))
                    messages.add(Message("Edgar", "Esto es una prueba para visualizar un "))
                    messages.add(Message("Edgar", "Esto es una prueba para visualizar un Esto es una prueba para visualizar unEsto es una prueba para visualizar un "))
                    messages.add(Message("Lexi", "Esto es una prueba para visualizar un Esto es una prueba para visualizar unEsto es una prueba para visualizar un "))
                    messages.add(Message("Lexi", "Prueba "))
                    messages.add(Message("Edgar", "Esto es una prueba para visualizar unEsto es una prueba para visualizar un "))
                    messages.add(Message("Edgar", "Esto es una prueba para visualizar un Esto es una prueba para visualizar un "))
                    messages.add(Message("Lexi", "Esto es una prueba para visualizar un Esto es una prueba para visualizar un "))
                    LazyColumn{
                        items(messages) { message ->
                            MessageCard(message)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        var isExpanded by remember { mutableStateOf(false)}
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = message.author,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = message.body,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}