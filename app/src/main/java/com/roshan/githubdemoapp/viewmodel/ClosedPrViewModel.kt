package com.roshan.githubdemoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roshan.githubdemoapp.datalib.ApiResult
import com.roshan.githubdemoapp.datalib.dispatcher.CoroutineDispatcherProvider
import com.roshan.githubdemoapp.datalib.model.PullRequest
import com.roshan.githubdemoapp.datalib.repositories.FetchClosedPullRequestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ClosedPrViewModel @Inject constructor(
    private val fetchClosedPullRequestRepository: FetchClosedPullRequestRepository,
    private val dispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private val _allClosedPr: MutableLiveData<ApiResult<ArrayList<PullRequest>>> =
        MutableLiveData()
    val allClosedPr: LiveData<ApiResult<ArrayList<PullRequest>>> by lazy { _allClosedPr }

    fun fetchAllClosedPr() {
        _allClosedPr.postValue(ApiResult.Loading(null, true))

        viewModelScope.launch {
            withContext(dispatcherProvider.io) {
                fetchClosedPullRequestRepository.fetchClosedPr().catch {
                    _allClosedPr.postValue(ApiResult.Error(ERROR_MESSAGE))
                }.collectLatest {
                    _allClosedPr.postValue(ApiResult.Success(it))
                }
            }
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "Something went wrong"
    }
}