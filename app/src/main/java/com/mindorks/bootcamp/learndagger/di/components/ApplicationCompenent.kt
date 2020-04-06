package com.mindorks.bootcamp.learndagger.di.components

import android.content.Context
import com.mindorks.bootcamp.demo.di.ApplicationContext
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.modules.ApplicationModule
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationCompenent {

    fun inject(myApplication: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable() : CompositeDisposable

}