package com.example.cardology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class EditSetDialog(val cardSet: CardSet) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(R.layout.dialog_set_edit, container, false)
        var button = v.findViewById<Button>(R.id.low_button)
        button.setOnClickListener {
            val newSet = cardSet.copy(priority = 3)
            MainActivity.cardSetViewModel.updateSetPriority(newSet)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.med_button)
        button.setOnClickListener {
            val newSet = cardSet.copy(priority = 2)
            MainActivity.cardSetViewModel.updateSetPriority(newSet)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.high_button)
        button.setOnClickListener {
            val newSet = cardSet.copy(priority = 1)
            MainActivity.cardSetViewModel.updateSetPriority(newSet)
            dismiss()
        }
        button = v.findViewById(R.id.set_delete)
        button.setOnClickListener {
            MainActivity.cardSetViewModel.deleteSet(cardSet)
            dismiss()
        }
        v.findViewById<TextView>(R.id.set_title).text = cardSet.title
        return v;
    }
}