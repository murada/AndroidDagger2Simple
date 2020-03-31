package com.mindorks.bootcamp.learndagger.data.local.dao

import androidx.room.*
import com.mindorks.bootcamp.learndagger.data.local.entity.Address
import io.reactivex.Single

@Dao
interface AddressDao {

    @Insert
    fun insert(address: Address): Single<Long>

    @Update
    fun update(address: Address): Single<Int>

    @Delete
    fun delete(address: Address): Single<Int>

    @Insert
    fun insertMany(vararg address: Address): Single<List<Long>>

    @Query("SELECT * FROM address")
    fun getAllAddresses(): Single<List<Address>>


}