package com.neo.daggerroom.di

import android.app.Application
import android.content.Context
import com.neo.daggerroom.database.AppDatabase
import com.neo.daggerroom.database.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val application: Application) {


    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao{
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun getRoomDbInstance(context: Context): AppDatabase{
        return AppDatabase.getAppDatabaseInstance(context)
    }

//    @Singleton
//    @Provides
//    fun getRoomDbInstance(): AppDatabase{
//        return AppDatabase.getAppDatabaseInstance(provideAppContext())
//    }

    @Singleton
    @Provides
    fun provideAppContext(): Context{
        return application.applicationContext
    }
}