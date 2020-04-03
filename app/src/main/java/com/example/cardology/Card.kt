package com.example.cardology

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cards_Table")
data class Card(@PrimaryKey @ColumnInfo(name = "cid") val cid : Int,
           @ColumnInfo(name = "sid") val sid : Int,
           @ColumnInfo(name = "question") val question : String,
           @ColumnInfo(name = "answer") val answer : String,
           @ColumnInfo(name = "priority") val priority : Int)