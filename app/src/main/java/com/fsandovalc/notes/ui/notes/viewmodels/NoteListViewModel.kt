package com.fsandovalc.notes.ui.notes.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fsandovalc.notes.data.datasources.LocalNoteDataSource
import com.fsandovalc.notes.data.repositories.NoteRepositoryImpl
import com.fsandovalc.notes.domain.models.NoteModel
import com.fsandovalc.notes.domain.repositories.NoteRepository
import com.fsandovalc.notes.domain.usecases.AddNotesUseCase
import com.fsandovalc.notes.domain.usecases.DeleteNotesUseCase
import com.fsandovalc.notes.domain.usecases.GetNotesUseCase

class NoteListViewModel : ViewModel() {
    private val dataSource = LocalNoteDataSource()
    private val repository: NoteRepository = NoteRepositoryImpl(dataSource)
    private val getNotesUseCase = GetNotesUseCase(repository)
    private val deleteNotesUseCase = DeleteNotesUseCase(repository)
    private val addNotesUseCase = AddNotesUseCase(repository)


    private val _noteListLiveData = MutableLiveData<List<NoteModel>>()
    val noteListLiveData: LiveData<List<NoteModel>>
        get() = _noteListLiveData

    fun onViewReady() {
        if (_noteListLiveData.value == null) {
            loadNotes()
        }
    }

    fun loadNotes() {
        val list = getNotesUseCase.execute()
        Log.i("testLoadNotes", list.toString())
        _noteListLiveData.value = list
    }

    fun deleteNote(id: Int) {
        deleteNotesUseCase.execute(id)
        val list = getNotesUseCase.execute()
        Log.i("testDeleteNotes",list.toString())
        _noteListLiveData.value = list
    }

    fun addNote(title: String, desc: String, tag: String){
        addNotesUseCase.execute(title,desc,tag)
        val list = getNotesUseCase.execute()
        Log.i("testAddedNotes",list.toString())
        _noteListLiveData.value = list
    }
}