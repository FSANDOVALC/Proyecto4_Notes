package com.fsandovalc.notes.ui.notes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import com.fsandovalc.notes.R
import com.fsandovalc.notes.ui.notes.viewmodels.NoteListViewModel

class AddNoteFragment : Fragment() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var tagEditText: EditText
    private lateinit var viewModel: NoteListViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)
        setupViews(view)
        viewModel = ViewModelProvider(this)[NoteListViewModel::class.java]
        return view
    }

    private fun setupViews(view: View) {
        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        tagEditText = view.findViewById(R.id.tagEditText)

        val submitButton = view.findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val tag = tagEditText.text.toString()

            viewModel.addNote(title,description,tag)

        }

        val backButton = view.findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack() // Pop the back stack to navigate back to the previous fragment
        }

    }
}

