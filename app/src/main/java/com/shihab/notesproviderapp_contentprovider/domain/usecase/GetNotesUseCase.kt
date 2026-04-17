package com.shihab.notesproviderapp_contentprovider.domain.usecase

import com.shihab.notesproviderapp_contentprovider.domain.model.Note
import com.shihab.notesproviderapp_contentprovider.domain.repository.NotesRepository

class GetNotesUseCase(
    private val repo: NotesRepository,
) {
    operator fun invoke(): List<Note> = repo.getNotes()
}
