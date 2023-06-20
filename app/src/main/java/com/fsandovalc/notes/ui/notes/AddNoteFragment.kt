package com.fsandovalc.notes.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.fsandovalc.notes.R

class AddNoteFragment : Fragment() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var tagEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)
        setupViews(view)
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

            // Use the retrieved data as needed (e.g., save to a database or perform an action)
            // Example: listener?.onNoteDataReceived(title, description, tag)
        }

        val backButton = view.findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            // Perform the fragment transaction to switch to another fragment
            val noteListFragment = NoteListFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, noteListFragment)
                .commit()
        }
    }
}

