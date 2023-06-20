package com.fsandovalc.notes.ui.notes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fsandovalc.notes.R
import com.fsandovalc.notes.domain.models.NoteModel
import com.fsandovalc.notes.ui.notes.adapters.NoteListAdapter
import com.fsandovalc.notes.ui.notes.viewmodels.NoteListViewModel

class NoteListFragment : Fragment() {

    private lateinit var viewModel: NoteListViewModel
    private lateinit var notesRecyclerView: RecyclerView

    private val adapter by lazy {
        NoteListAdapter(
            onItemLongClicked = { item -> onListItemClicked(item) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note_list, container, false)
        initViews(view)
        viewModel = ViewModelProvider(this)[NoteListViewModel::class.java]
        observe()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewReady()
    }

    private fun initViews(view: View) {
        with(view) {
            notesRecyclerView = findViewById(R.id.notes_list)
            notesRecyclerView.adapter = adapter
            notesRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    RecyclerView.VERTICAL
                )
            )
            notesRecyclerView.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)


            //Enable the add_task_button to change fragment to AddNoteFragment
            val addTaskButton = view.findViewById<Button>(R.id.add_task_button)

            addTaskButton.setOnClickListener {
                val addNoteFragment = AddNoteFragment()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, addNoteFragment)
                    .addToBackStack(null)
                    .commit()
            }

        }
    }

    private fun observe() {
        viewModel.noteListLiveData.observe(viewLifecycleOwner) { list ->
            adapter.setData(list)
        }
    }

    private fun onListItemClicked(noteModel: NoteModel) {
        Toast.makeText(context, "${noteModel.title} was removed from list", Toast.LENGTH_LONG).show()
        // Remove items from the datasource and refresh view
        viewModel.deleteNote(noteModel.id)
        viewModel.onViewReady()
    }
}