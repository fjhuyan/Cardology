package com.example.cardology

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(CardSet::class, Card::class), version = 1, exportSchema = false)
public abstract class CardSetDatabase : RoomDatabase() {
    abstract fun cardSetDao() : CardSetDao

    companion object {
        @Volatile
        private var INSTANCE: CardSetDatabase? = null

        fun getDatabase(context: Context) : CardSetDatabase {
            val tempInstance = INSTANCE;
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CardSetDatabase::class.java,
                    "Word_Set_Database").build()
                INSTANCE = instance
                return instance;
            }
        }
    }
}

