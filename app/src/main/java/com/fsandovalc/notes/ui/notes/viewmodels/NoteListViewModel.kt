package com.fsandovalc.notes.ui.notes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fsandovalc.notes.data.datasources.LocalNoteDataSource
import com.fsandovalc.notes.data.repositories.NoteRepositoryImpl
import com.fsandovalc.notes.domain.models.NoteModel
import com.fsandovalc.notes.domain.repositories.NoteRepository
import com.fsandovalc.notes.domain.usecases.GetNotesUseCase

class NoteListViewModel : ViewModel() {
    private val dataSource = LocalNoteDataSource()
    private val repository: NoteRepository = NoteRepositoryImpl(dataSource)
    private val getNotesUseCase = GetNotesUseCase(repository)

    private val _noteListLiveData = MutableLiveData<List<NoteModel>>()
    val noteListLiveData: LiveData<List<NoteModel>>
        get() = _noteListLiveData

    fun onViewReady() {
        val list = getNotesUseCase.execute()
        _noteListLiveData.value = list
    }
}