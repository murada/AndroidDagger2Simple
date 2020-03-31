package com.mindorks.bootcamp.learndagger.data.local.dao

import androidx.room.*
import com.mindorks.bootcamp.learndagger.data.local.entity.User
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    fun insert(user: User): Single<Long>

    @Update
    fun update(user: User): Single<Int>

    @Delete
    fun delete(user: User): Single<Int>

    @Insert
    fun insertMany(vararg users: User): Single<List<Long>>

    @Query("SELECT * FROM users")
    fun getAllUsers(): Single<List<User>>

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    fun getUserByID(id:Long) : Single<User>

    @Query("SELECT count(*) FROM users")
    fun count():Single<Int>
}