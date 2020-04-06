package com.mindorks.bootcamp.learndagger.di.modules

import android.content.Context
import androidx.room.Room
import com.mindorks.bootcamp.demo.di.ApplicationContext
import com.mindorks.bootcamp.demo.di.DatabaseInfo
import com.mindorks.bootcamp.demo.di.NetworkInfo
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.local.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule (var myApplication: MyApplication){



    @Provides
    @ApplicationContext
    fun provideContext(): Context = myApplication

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return "aaa"
    }

    @Provides
    fun provideDatabaseVersion(): Int {
        return 1
    }

    @Provides
    @NetworkInfo
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