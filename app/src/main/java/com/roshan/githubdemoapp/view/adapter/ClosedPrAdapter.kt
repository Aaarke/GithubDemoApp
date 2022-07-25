package com.roshan.githubdemoapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roshan.githubdemoapp.R
import com.roshan.githubdemoapp.databinding.ItemPullRequestBinding
import com.roshan.githubdemoapp.datalib.model.PullRequest

class ClosedPrAdapter(): RecyclerView.Adapter<ClosedPrAdapter.ClosedPr>() {
    private var list:ArrayList<PullRequest>?=null

    fun setAdapter(listOfPullRequest: ArrayList<PullRequest>){
        this.list=listOfPullRequest
        notifyDataSetChanged()
    }

    inner class  ClosedPr (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(pullRequest: PullRequest) {

        }

        private val binding = ItemPullRequestBinding.bind(itemView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClosedPr {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_pull_request,parent,false)
        return  ClosedPr(view)
    }

    override fun onBindViewHolder(holder: ClosedPr, position: Int) {
        list?.let {
            holder.bind(it[position])

        }
    }

    override fun getItemCount(): Int {
       return list?.size?:0
    }
}