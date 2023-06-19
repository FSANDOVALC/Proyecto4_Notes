package com.fsandovalc.notes.data.mappers

import com.fsandovalc.notes.data.mappers.TagMapper.toTag
import com.fsandovalc.notes.data.models.LocalNote
import com.fsandovalc.notes.domain.models.NoteModel

object NoteMapper {

    fun LocalNote.toNote(): NoteModel {
        return NoteModel(
            id = this.id,
            title = this.title,
            description = this.description,
            tag = this.tag.toTag(),
            date = this.date
        )
    }
}