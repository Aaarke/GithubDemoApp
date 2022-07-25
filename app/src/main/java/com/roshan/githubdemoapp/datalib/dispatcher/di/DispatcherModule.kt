package com.roshan.githubdemoapp.datalib.dispatcher.di

import com.roshan.githubdemoapp.datalib.dispatcher.CoroutineDispatcherProvider
import com.roshan.githubdemoapp.datalib.dispatcher.RealCoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DispatcherModule {
    @Provides
    @Singleton
    fun providesCoroutineDispatcher(): CoroutineDispatcherProvider {
        return RealCoroutineDispatcherProvider()
    }
}
