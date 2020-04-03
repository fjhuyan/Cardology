package com.example.cardology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DeleteDialog(val card: Card) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dialog_delete, container, false)
        val noButton = v.findViewById<Button>(R.id.no_button)
        val yesButton = v.findViewById<Button>(R.id.yes_button)
        noButton.setOnClickListener {
            dismiss()
        }
        yesButton.setOnClickListener {
            MainActivity.cardSetViewModel.deleteCard(card)
            dismiss()
        }
        return v
    }
}