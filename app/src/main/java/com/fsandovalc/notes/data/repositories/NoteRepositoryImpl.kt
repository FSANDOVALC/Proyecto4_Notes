package com.fsandovalc.notes.data.repositories

import com.fsandovalc.notes.data.datasources.LocalNoteDataSource
import com.fsandovalc.notes.domain.models.NoteModel
import com.fsandovalc.notes.data.mappers.NoteMapper.toNote
import com.fsandovalc.notes.domain.repositories.NoteRepository

class NoteRepositoryImpl(
    private val localNoteDataSource: LocalNoteDataSource
) : NoteRepository {

    override fun getAllNotes(): List<NoteModel> =
        localNoteDataSource.getAllNotes()
            .map { item -> item.toNote() }

}