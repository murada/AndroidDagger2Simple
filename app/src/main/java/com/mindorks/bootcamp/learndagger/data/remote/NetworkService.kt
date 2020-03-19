package com.mindorks.bootcamp.learndagger.data.remote

import android.content.Context
import com.mindorks.bootcamp.learndagger.di.qualifier.ApiKey
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Dummy class to simulate the actual NetworkService using Retrofit or OkHttp etc
 */
@Singleton
class NetworkService // do the initialisation here
@Inject constructor(private val context: Context, @param:ApiKey private val apiKey: String) {
    val dummyData: String
        get() = "NETWORK_DUMMY_DATA"

}