package com.example.cardology

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CardSetDao {

    @Query("SELECT * from Word_Set_Table ORDER BY priority ASC")
    fun getAllSets() : LiveData<List<CardSet>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(set: CardSet)
    // suspend indicates method can be suspended for later execution

    @Query("DELETE FROM Word_Set_Table")
    suspend fun deleteAll()

    @Query("SELECT * FROM Cards_Table ORDER BY priority ASC")
    fun getCards() : LiveData<List<Card>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(card: Card)

    @Update
    suspend fun updateCard(card: Card)

    @Update
    suspend fun updateSet(cardSet : CardSet)

    @Delete
    suspend fun deleteCard(card: Card)

    @Delete
    suspend fun deleteSet(cardSet: CardSet)

    @Query("DELETE FROM Cards_Table WHERE sid = :SID")
    suspend fun deleteCardsFromSet(SID: Int)
}