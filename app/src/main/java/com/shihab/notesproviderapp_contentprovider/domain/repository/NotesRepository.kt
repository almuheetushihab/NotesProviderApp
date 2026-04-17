package com.shihab.notesproviderapp_contentprovider.domain.repository

import com.shihab.notesproviderapp_contentprovider.domain.model.Note

interface NotesRepository {
    fun addNote(title: String)
    fun getNotes(): List<Note>
}