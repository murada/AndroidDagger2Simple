package com.mindorks.bootcamp.learndagger.di.modules

import android.content.Context
import androidx.room.Room
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.local.MIGRATION_1_2
import com.mindorks.bootcamp.learndagger.di.qualifier.ApiKey
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseName
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule (var myApplication: MyApplication){


    @Provides
    fun provideContext(): Context {
        return myApplication
    }

    @Provides
    @DatabaseName
    fun provideDatabaseName(): String {
        return "aaa"
    }

    @Provides
    fun provideDatabaseVersion(): Int {
        return 1
    }

    @Provides
    @ApiKey
    fun provideApiKey(): String {
        return "ssss"
    }

    @Singleton
    @Provides
    fun provideDatabaseService(): DatabaseService = Room.databaseBuilder(
            myApplication,
            DatabaseService::class.java,
            "bootcamp=database-project-db"
    ).addMigrations(MIGRATION_1_2)
            .build()


    @Provides
    fun provideCompositeDisposable():CompositeDisposable = CompositeDisposable()

}