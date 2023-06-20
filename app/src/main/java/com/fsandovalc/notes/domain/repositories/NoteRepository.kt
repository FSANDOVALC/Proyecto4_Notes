package com.fsandovalc.notes.domain.repositories

import com.fsandovalc.notes.data.models.LocalNote
import com.fsandovalc.notes.domain.models.NoteModel

interface NoteRepository {
    fun getAllNotes(): List<NoteModel>

    fun deleteNote(id: Int)

    fun addNote(localNote: LocalNote)

    fun updateNote(note: LocalNote)
}