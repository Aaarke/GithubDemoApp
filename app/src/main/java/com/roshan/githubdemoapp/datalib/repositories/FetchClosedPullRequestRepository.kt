package com.roshan.githubdemoapp.datalib.repositories

import com.roshan.githubdemoapp.datalib.services.PullRequestService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchClosedPullRequestRepository @Inject constructor(private val pullRequestService: PullRequestService) {



    fun fetchClosedPr() = flow {
        val newsItemList = pullRequestService.fetchClosedPr()
        emit(newsItemList)
    }

}