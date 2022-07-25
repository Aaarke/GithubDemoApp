package com.roshan.githubdemoapp.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roshan.githubdemoapp.databinding.ActivityPullRequestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PullRequestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPullRequestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makePRApicall()
    }

    private fun makePRApicall() {

    }
}