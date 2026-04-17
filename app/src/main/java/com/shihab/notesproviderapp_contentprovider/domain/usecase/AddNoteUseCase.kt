package com.shihab.notesproviderapp_contentprovider.domain.usecase

import com.shihab.notesproviderapp_contentprovider.domain.repository.NotesRepository

class AddNoteUseCase(
    private val repo: NotesRepository,
) {
    operator fun invoke(title: String) = repo.addNote(title)
}
