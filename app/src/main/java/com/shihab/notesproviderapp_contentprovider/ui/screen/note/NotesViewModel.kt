package com.shihab.notesproviderapp_contentprovider.ui.screen.note

import androidx.lifecycle.ViewModel
import com.shihab.notesproviderapp_contentprovider.domain.model.Note
import com.shihab.notesproviderapp_contentprovider.domain.usecase.AddNoteUseCase
import com.shihab.notesproviderapp_contentprovider.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class NotesViewModel(
    private val addNoteUseCase: AddNoteUseCase,
    private val getNotesUseCase: GetNotesUseCase
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes

    fun loadNotes() {
        _notes.value = getNotesUseCase()
    }

    fun addNote(title: String) {
        addNoteUseCase(title)
        loadNotes()
    }
}