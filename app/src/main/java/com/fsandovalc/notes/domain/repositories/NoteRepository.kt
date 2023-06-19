package com.fsandovalc.notes.domain.repositories

import com.fsandovalc.notes.domain.models.NoteModel

interface NoteRepository {

    fun getAllNotes(): List<NoteModel>
}