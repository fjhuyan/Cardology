package com.example.cardology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class EditCardDialog(val card: Card) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(R.layout.dialog_card_edit, container, false)
        val questionText : EditText = v.findViewById(R.id.card_question)
        questionText.setText(card.question, TextView.BufferType.EDITABLE)
        val answerText : EditText = v.findViewById(R.id.card_answer)
        answerText.setText(card.answer, TextView.BufferType.EDITABLE)
        var button = v.findViewById<Button>(R.id.low_button)
        button.setOnClickListener {
            val question = questionText.text.toString()
            val answer = answerText.text.toString()
            val newCard = card.copy(question = question, answer = answer, priority = 3)
            MainActivity.cardSetViewModel.updateCard(newCard)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.med_button)
        button.setOnClickListener {
            val question = questionText.text.toString()
            val answer = answerText.text.toString()
            val newCard = card.copy(question = question, answer = answer, priority = 2)
            MainActivity.cardSetViewModel.updateCard(newCard)
            dismiss()
        }
        button = v.findViewById<Button>(R.id.high_button)
        button.setOnClickListener {
            val question = questionText.text.toString()
            val answer = answerText.text.toString()
            val newCard = card.copy(question = question, answer = answer, priority = 1)
            MainActivity.cardSetViewModel.updateCard(newCard)
            dismiss()
        }

        button = v.findViewById<Button>(R.id.card_delete)
        button.setOnClickListener {
            MainActivity.cardSetViewModel.deleteCard(card)
            dismiss()
        }

        return v;
    }
}