package com.fsandovalc.notes.domain.usecases

import android.util.Log
import com.fsandovalc.notes.domain.models.NoteModel
import com.fsandovalc.notes.domain.repositories.NoteRepository

class DeleteNotesUseCase(
    private val noteRepository: NoteRepository
) {

    fun execute(id: Int){
        Log.i("testDelete","${id} was supposed to be removed")
        noteRepository.deleteNote(id)
    }


}