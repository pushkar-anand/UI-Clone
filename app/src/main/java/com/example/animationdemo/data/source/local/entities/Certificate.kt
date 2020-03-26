package com.example.animationdemo.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "certificates")
data class Certificate(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "certificate_id")
    val id: Long,

    @ColumnInfo(name = "certificate_name")
    var name: String

)