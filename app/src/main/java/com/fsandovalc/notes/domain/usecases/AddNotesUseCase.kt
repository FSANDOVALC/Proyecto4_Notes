package com.fsandovalc.notes.domain.usecases

import com.fsandovalc.notes.data.models.LocalNote
import com.fsandovalc.notes.data.models.LocalTag
import com.fsandovalc.notes.domain.repositories.NoteRepository
import java.time.LocalDate

class AddNotesUseCase(
    private val noteRepository: NoteRepository
) {

    fun execute(title:String, description: String, tag: String){

        val currentDate = LocalDate.now()
        val currentDateAsInt = currentDate.toEpochDay().toInt()
        val localTagModel = LocalTag(
            6,
            tag
        )

        val localNoteModel = LocalNote(
            5,
            title,
            description,
            localTagModel,
            currentDateAsInt
        )
        noteRepository.addNote(localNoteModel)
    }
}