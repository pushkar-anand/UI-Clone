package com.example.animationdemo.data.source.local.entities

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "certificates")
data class Certificate @JvmOverloads constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "certificate_id")
    val id: Long,

    @ColumnInfo(name = "certificate_name")
    var name: String,

    @DrawableRes
    @Ignore
    var illustration: Int = 0

)