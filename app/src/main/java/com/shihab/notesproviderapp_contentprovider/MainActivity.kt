package com.shihab.notesproviderapp_contentprovider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shihab.notesproviderapp_contentprovider.data.repository.NotesRepositoryImpl
import com.shihab.notesproviderapp_contentprovider.domain.usecase.AddNoteUseCase
import com.shihab.notesproviderapp_contentprovider.domain.usecase.GetNotesUseCase
import com.shihab.notesproviderapp_contentprovider.ui.screen.note.NotesScreen
import com.shihab.notesproviderapp_contentprovider.ui.screen.note.NotesViewModel
import com.shihab.notesproviderapp_contentprovider.ui.theme.NotesProviderAppContentProviderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = NotesRepositoryImpl(this)
        val vm =
            NotesViewModel(
                AddNoteUseCase(repo),
                GetNotesUseCase(repo),
            )

        setContent {
            NotesScreen(vm)
        }

        vm.loadNotes()
    }
}
