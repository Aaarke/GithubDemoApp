package com.roshan.githubdemoapp.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.roshan.githubdemoapp.databinding.ActivityPullRequestBinding
import com.roshan.githubdemoapp.view.adapter.ClosedPrAdapter
import com.roshan.githubdemoapp.viewmodel.ClosedPrViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PullRequestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPullRequestBinding
    private val closedPrViewModel:ClosedPrViewModel by viewModels()
    private val closedPrAdapter:ClosedPrAdapter by lazy { ClosedPrAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        makePRApicall()
    }

    private fun setAdapter() {
        binding.rvClosedPr.adapter=closedPrAdapter
    }

    private fun makePRApicall() {
        closedPrViewModel.fetchAllClosedPr()
    }
}