package com.example.cardology

import androidx.lifecycle.LiveData

class CardSetRepo(private val dao : CardSetDao) {

    val allcardSets: LiveData<List<CardSet>> = dao.getAllSets()
    val cards: LiveData<List<Card>> = dao.getCards()

    suspend fun insert(cardSet: CardSet) {
        dao.insert(cardSet)
    }

    suspend fun insert(card: Card) {
        dao.insert(card)
    }

    suspend fun updateCard(card: Card) {
        dao.updateCard(card)
    }

    suspend fun deleteCard(card: Card) {
        dao.deleteCard(card)
    }

    suspend fun deleteSet(cardSet: CardSet) {
        dao.deleteSet(cardSet)
        dao.deleteCardsFromSet(cardSet.sid)
    }

    suspend fun updateSetPriority(cardSet : CardSet) {
        dao.updateSetPriority(cardSet)
    }
}