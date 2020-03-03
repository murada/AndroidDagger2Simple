package com.mindorks.bootcamp.learndagger.data.local

import android.content.Context
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseName
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Dummy class to simulate the actual Database using Room or Realm etc
 */
@Singleton
class DatabaseService // do the initialisation here
@Inject constructor(private val context: Context, @param:DatabaseName private val databaseName: String, private val version: Int) {
    val dummyData: String
        get() = "DATABASE_DUMMY_DATA"

}