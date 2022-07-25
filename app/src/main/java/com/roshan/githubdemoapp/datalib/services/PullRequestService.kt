package com.roshan.githubdemoapp.datalib.services

import com.roshan.githubdemoapp.datalib.model.PullRequest
import retrofit2.http.GET

interface PullRequestService {

    @GET(FETCH_CLOSED_PR_END_POINT)
    suspend fun fetchClosedPr(): ArrayList<PullRequest>

    companion object {
        const val FETCH_CLOSED_PR_END_POINT = "repos/Aaarke/GithubDemoApp/pulls?state=closed"
    }
}