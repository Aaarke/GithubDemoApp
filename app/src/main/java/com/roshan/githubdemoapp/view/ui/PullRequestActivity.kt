package com.roshan.githubdemoapp.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.roshan.githubdemoapp.databinding.ActivityPullRequestBinding
import com.roshan.githubdemoapp.viewmodel.ClosedPrViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PullRequestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPullRequestBinding
    private val closedPrViewModel:ClosedPrViewModel by  viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        closedPrViewModel.fetchAllClosedPr()

    }
}