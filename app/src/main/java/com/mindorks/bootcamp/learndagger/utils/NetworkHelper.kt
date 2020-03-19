package com.mindorks.bootcamp.learndagger.utils

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(context:Context) {

    fun isNetworkConnected():Boolean{
        return false
    }
}