package com.example.nosmokeapp.di

import android.content.Context
import com.example.nosmokeapp.repository.PrefRepository
import com.example.nosmokeapp.repository.PrefRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePrefRepository(@ApplicationContext context: Context):PrefRepository{
        return PrefRepositoryImpl(context)
    }

}