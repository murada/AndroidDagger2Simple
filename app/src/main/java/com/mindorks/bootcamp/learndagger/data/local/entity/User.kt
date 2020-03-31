package com.mindorks.bootcamp.learndagger.data.local.entity

import androidx.room.*

@Entity(tableName = "users", foreignKeys = [ForeignKey(
        entity = Address::class, parentColumns = ["id"], childColumns = ["address_id"], onDelete = ForeignKey.CASCADE)
]
)
data class User(

        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,
        @ColumnInfo(name = "name")
        var name: String,
        @ColumnInfo(name = "address_id")
        var addressId: Long,

        @Ignore
        var selected: Boolean = false
) {
    constructor() : this(0, "", 0, false)
}