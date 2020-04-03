package com.example.cardology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards2)
        val sid = intent.getIntExtra(CardSetAdapter.SET_ID_EXTRA, 0)
        findViewById<TextView>(R.id.small_text).text = intent.getStringExtra(CardSetAdapter.SET_TITLE)

        val recyclerView = findViewById<RecyclerView>(R.id.cards_recyclerview)
        val adapter = CardsAdapter(this, sid)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.card_fab)
        fab.setOnClickListener {
            val dialog = AddCardDialog(sid)
            dialog.show(supportFragmentManager, "add_card_dialog")
        }

        MainActivity.cardSetViewModel.allCards.observe(this, Observer {
                sets -> sets?.let {adapter.setCardSets(it)}
        })
    }

}
