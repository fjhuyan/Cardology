package com.example.cardology

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Word_Set_Table")
data class CardSet(@PrimaryKey @ColumnInfo(name = "sid") val sid: Int,
                   @ColumnInfo(name = "title") val title: String,
                   @ColumnInfo(name = "priority") val priority: Int)