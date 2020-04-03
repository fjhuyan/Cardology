package com.example.cardology

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CardsAdapter internal constructor(val context: Context, val sid : Int):
    RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var cards = emptyList<Card>()

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView : CardView = itemView.findViewById(R.id.question_card_item_card)
        val setItemView: TextView = itemView.findViewById(R.id.question_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(inflater.inflate(R.layout.question_card_item, parent, false))
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val current = cards[position]
        holder.setItemView.text = current.question
        when (current.priority) {
            3 -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.low))
            }
            2 -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.med))
            }
            else -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.high))
            }
        }
        holder.cardView.setOnClickListener {
            val dialog = AnswerCardDialog(current)
            dialog.show((context as AppCompatActivity).supportFragmentManager, "answer_dialog")
        }
        holder.cardView.setOnLongClickListener {
            val dialog = DeleteDialog(current)
            dialog.show((it.context as AppCompatActivity).supportFragmentManager, "delete")
            true
        }
    }

    fun setCardSets(newCards : List<Card>) {
        this.cards = newCards.filter{it.sid == sid}
        notifyDataSetChanged()
    }
}