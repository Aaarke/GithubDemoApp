package com.roshan.githubdemoapp.datalib.services.di

import com.roshan.githubdemoapp.datalib.services.PullRequestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModuleProvider {

    @Provides
    @Singleton
    fun providesRetrofit(retrofit: Retrofit): PullRequestService {
        return retrofit.create(PullRequestService::class.java)
    }

}