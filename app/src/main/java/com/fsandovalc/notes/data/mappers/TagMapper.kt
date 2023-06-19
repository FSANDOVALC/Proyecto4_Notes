package com.fsandovalc.notes.data.mappers

import com.fsandovalc.notes.data.models.LocalTag
import com.fsandovalc.notes.domain.models.TagModel

object TagMapper {

    fun LocalTag.toTag(): TagModel = TagModel(
        id = this.id,
        title = this.title
    )
}