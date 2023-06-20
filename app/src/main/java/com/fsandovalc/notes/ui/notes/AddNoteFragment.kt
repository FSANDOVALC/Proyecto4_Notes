package com.fsandovalc.notes.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fsandovalc.notes.R

class AddNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        submitButton.setOnClickListener {
//            val title = titleEditText.text.toString()
//            val description = descriptionEditText.text.toString()
//            val tag = tagEditText.text.toString()
//        }
    }
}