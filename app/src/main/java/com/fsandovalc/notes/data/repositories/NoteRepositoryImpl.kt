package com.fsandovalc.notes.data.repositories

import android.util.Log
import com.fsandovalc.notes.data.datasources.LocalNoteDataSource
import com.fsandovalc.notes.domain.models.NoteModel
import com.fsandovalc.notes.data.mappers.NoteMapper.toNote
import com.fsandovalc.notes.data.models.LocalNote
import com.fsandovalc.notes.domain.repositories.NoteRepository

class NoteRepositoryImpl(
    private val localNoteDataSource: LocalNoteDataSource
) : NoteRepository {

    override fun getAllNotes(): List<NoteModel> =
        localNoteDataSource.getAllNotes()
            .map { item -> item.toNote() }

    override fun deleteNote(id: Int) {
        Log.i("testDelete","${id} was supposed to be removed - NoteRepositoryImpl")
        localNoteDataSource.deleteNote(id)
    }

    override fun addNote(localNote: LocalNote) {
        localNoteDataSource.addNote(localNote)
    }

    override fun updateNote(note: LocalNote) {
        localNoteDataSource.updateNote(note)
    }
}