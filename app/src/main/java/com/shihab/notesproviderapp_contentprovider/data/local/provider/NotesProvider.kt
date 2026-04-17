package com.shihab.notesproviderapp_contentprovider.data.local.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.shihab.notesproviderapp_contentprovider.data.local.db.DBHelper

class NotesProvider : ContentProvider() {
    private lateinit var dbHelper: DBHelper

    override fun onCreate(): Boolean {
        dbHelper = DBHelper(context!!)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?,
    ): Cursor {
        val db = dbHelper.readableDatabase
        return db.rawQuery("SELECT * FROM notes", null)
    }

    override fun insert(
        uri: Uri,
        values: ContentValues?,
    ): Uri {
        val db = dbHelper.writableDatabase
        db.insert("notes", null, values)
        context?.contentResolver?.notifyChange(uri, null)
        return uri
    }

    override fun delete(
        uri: Uri,
        selection: String?,
        selectionArgs: Array<out String>?,
    ): Int {
        val db = dbHelper.writableDatabase
        return db.delete("notes", selection, selectionArgs)
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?,
    ): Int {
        val db = dbHelper.writableDatabase
        return db.update("notes", values, selection, selectionArgs)
    }

    override fun getType(uri: Uri): String? = null
}
