package com.example.cardology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class DeleteDialog(val card: Card) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dialog_delete, container, false)
        val editButton = v.findViewById<Button>(R.id.edit_card_button)
        val yesButton = v.findViewById<Button>(R.id.yes_button)
        editButton.setOnClickListener {
            val editDialog = EditCardDialog(card)
            editDialog.show((context as AppCompatActivity).supportFragmentManager, "edit_card_dialog")
            dismiss()
        }
        yesButton.setOnClickListener {
            MainActivity.cardSetViewModel.deleteCard(card)
            dismiss()
        }
        return v
    }
}