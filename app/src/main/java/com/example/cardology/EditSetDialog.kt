package com.example.cardology

import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class EditSetDialog(val cardSet: CardSet) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(R.layout.dialog_set_edit, container, false)
        val title : EditText = v.findViewById<EditText>(R.id.set_title)
        title.setText(cardSet.title, TextView.BufferType.EDITABLE)
        var button = v.findViewById<Button>(R.id.low_button)
        button.setOnClickListener {
            val newSet = cardSet.copy(title = title.text.toString(), priority = 3)
            MainActivity.cardSetViewModel.updateSet(newSet)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.med_button)
        button.setOnClickListener {
            val newSet = cardSet.copy(title = title.text.toString(), priority = 2)
            MainActivity.cardSetViewModel.updateSet(newSet)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.high_button)
        button.setOnClickListener {
            val newSet = cardSet.copy(title = title.text.toString(), priority = 1)
            MainActivity.cardSetViewModel.updateSet(newSet)
            dismiss()
        }
        button = v.findViewById(R.id.set_delete)
        button.setOnClickListener {
            MainActivity.cardSetViewModel.deleteSet(cardSet)
            dismiss()
        }
        return v;
    }
}