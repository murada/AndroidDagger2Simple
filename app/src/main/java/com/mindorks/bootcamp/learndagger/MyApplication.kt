package com.mindorks.bootcamp.learndagger

import android.app.Application
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.components.ApplicationCompenent
import com.mindorks.bootcamp.learndagger.di.components.DaggerActivityComponent
import com.mindorks.bootcamp.learndagger.di.components.DaggerApplicationCompenent
import com.mindorks.bootcamp.learndagger.di.modules.ApplicationModule
import javax.inject.Inject

class MyApplication:Application() {

    @Inject
    lateinit var databaseService: DatabaseService
    @Inject
    lateinit var networkService: NetworkService

    lateinit var compenent:ApplicationCompenent

    override fun onCreate() {
        super.onCreate()

        compenent = DaggerApplicationCompenent.builder().applicationModule(ApplicationModule(this)).build()
        compenent.inject(this)
    }
}