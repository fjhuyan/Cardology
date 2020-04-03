package com.example.cardology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class AnswerCardDialog(val card : Card) : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(R.layout.dialog_answer, container, false)
        val text : TextView = v.findViewById(R.id.dialog_card_answer)
        text.text = card.answer
        var button = v.findViewById<Button>(R.id.low_button)
        button.setOnClickListener {
            val newCard = card.copy(priority = 3)
            MainActivity.cardSetViewModel.updateCard(newCard)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.med_button)
        button.setOnClickListener {
            val newCard = card.copy(priority = 2)
            MainActivity.cardSetViewModel.updateCard(newCard)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.high_button)
        button.setOnClickListener {
            val newCard = card.copy(priority = 1)
            MainActivity.cardSetViewModel.updateCard(newCard)
            dismiss()
        }
        return v;
    }
}