package com.shihab.notesproviderapp_contentprovider.ui.screen.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotesScreen(viewModel: NotesViewModel) {

    val notes by viewModel.notes.collectAsState()

    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter Note") }
        )

        Button(onClick = {
            viewModel.addNote(text)
            text = ""
        }) {
            Text("Add Note")
        }

        LazyColumn {
            items(notes) {
                Text(it.title, fontSize = 18.sp)
            }
        }
    }
}