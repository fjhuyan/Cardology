package com.example.cardology

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class AddSetActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_set)
        editWordView = findViewById(R.id.edit_word)
        supportActionBar?.hide()

        var button = findViewById<Button>(R.id.low_button)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(ADD_SET_TITLE, word)
                replyIntent.putExtra(ADD_SET_PRIORITY, 3)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

        button = findViewById<Button>(R.id.med_button)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(ADD_SET_TITLE, word)
                replyIntent.putExtra(ADD_SET_PRIORITY, 2)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

        button = findViewById<Button>(R.id.high_button)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(ADD_SET_TITLE, word)
                replyIntent.putExtra(ADD_SET_PRIORITY, 1)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val ADD_SET_TITLE = "com.example.android.wordlistsql.REPLY"
        const val ADD_SET_PRIORITY = "set_priority"
    }
}