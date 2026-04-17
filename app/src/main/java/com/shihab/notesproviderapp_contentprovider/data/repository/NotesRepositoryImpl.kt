package com.shihab.notesproviderapp_contentprovider.data.repository

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import com.shihab.notesproviderapp_contentprovider.domain.model.Note
import com.shihab.notesproviderapp_contentprovider.domain.repository.NotesRepository

class NotesRepositoryImpl(
    private val context: Context,
) : NotesRepository {
    private val uri = "content://com.shihab.notesprovider/notes".toUri()

    override fun addNote(title: String) {
        val values =
            ContentValues().apply {
                put("title", title)
            }
        context.contentResolver.insert(uri, values)
    }

    override fun getNotes(): List<Note> {
        val list = mutableListOf<Note>()

        val cursor = context.contentResolver.query(uri, null, null, null, null)

        cursor?.use {
            while (it.moveToNext()) {
                val id = it.getInt(it.getColumnIndexOrThrow("id"))
                val title = it.getString(it.getColumnIndexOrThrow("title"))
                list.add(Note(id, title))
            }
        }

        return list
    }
}
