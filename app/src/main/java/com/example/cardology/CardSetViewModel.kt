package com.example.cardology

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardSetViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: CardSetRepo
    val allSets: LiveData<List<CardSet>>
    val allCards: LiveData<List<Card>>

    init {
        val dao = CardSetDatabase.getDatabase(application).cardSetDao()
        repo = CardSetRepo(dao)
        allSets = repo.allcardSets
        allCards = repo.cards
    }

    fun insert(cardSet: CardSet) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(cardSet)
        }
    }

    fun insert(card: Card) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(card)
        }
    }

    fun updateCard(card: Card) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateCard(card)
        }
    }

    fun updateSet(cardSet : CardSet) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateSet(cardSet)
        }
    }

    fun deleteCard(card: Card) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteCard(card)
        }
    }

    fun deleteSet(cardSet: CardSet) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteSet(cardSet)
        }
    }
}