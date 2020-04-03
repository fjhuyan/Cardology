package com.example.cardology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class AddCardDialog(val sid: Int) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.setCancelable(false)
        val v : View = inflater.inflate(R.layout.dialog_add_card, container, false)
        val questionText : EditText = v.findViewById(R.id.card_question)
        val answerText : EditText = v.findViewById(R.id.card_answer)
        var button = v.findViewById<Button>(R.id.low_button)
        button.setOnClickListener {
            val question = questionText.text.toString()
            val answer = answerText.text.toString()
            MainActivity.cardSetViewModel.insert(Card(question.hashCode() * this.sid + answer.hashCode(), this.sid, question, answer, 3))
            dismiss()
        }
        button = v.findViewById<Button>(R.id.med_button)
        button.setOnClickListener {
            val question = questionText.text.toString()
            val answer = answerText.text.toString()
            MainActivity.cardSetViewModel.insert(Card(question.hashCode() * this.sid + answer.hashCode(), this.sid, question, answer, 2))
            dismiss()
        }
        button = v.findViewById<Button>(R.id.high_button)
        button.setOnClickListener {
            val question = questionText.text.toString()
            val answer = answerText.text.toString()
            MainActivity.cardSetViewModel.insert(Card(question.hashCode() * this.sid + answer.hashCode(), this.sid, question, answer, 1))
            dismiss()
        }
        return v;
    }

    companion object {
        const val CARD_QUESTION_REPLY = "card_question"
        const val CARD_ANSWER_REPLY = "card_answer"
        const val CARD_PRIORITY_REPLY = "card_priority"
    }

}