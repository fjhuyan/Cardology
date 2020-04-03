package com.example.cardology

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CardSetAdapter internal constructor(val context: Context):
        RecyclerView.Adapter<CardSetAdapter.SetViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var sets = emptyList<CardSet>()

    inner class SetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView : CardView = itemView.findViewById(R.id.card_item_view)
        val setItemView: TextView = itemView.findViewById(R.id.set_item_view_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        val itemView = inflater.inflate(R.layout.card_simple_text_item, parent, false)
        return SetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {
        val current = sets[position]
        holder.setItemView.text = current.title
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
            val intent = Intent(it.context, CardsActivity::class.java)
            intent.putExtra(SET_ID_EXTRA, current.sid)
            intent.putExtra(SET_TITLE, current.title)
            it.context.startActivity(intent)
        }
        holder.cardView.setOnLongClickListener {
            val dialog = EditSetDialog(current)
            dialog.show((context as AppCompatActivity).supportFragmentManager, "edit_set")
            true
        }
    }

    internal fun setcardSets(sets: List<CardSet>) {
        this.sets = sets
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return sets.size
    }

    companion object {
        const val SET_ID_EXTRA = "SET_ID"
        const val SET_TITLE = "SET_TITLE"
    }
}