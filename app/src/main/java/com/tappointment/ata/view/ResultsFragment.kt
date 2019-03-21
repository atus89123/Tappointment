package com.tappointment.ata.view


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.tappointment.ata.R
import com.tappointment.ata.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_results.*

class ResultsFragment : Fragment() {

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProviders.of(it).get(ViewModel::class.java)

            viewModel.postSearch { mainResult, error ->
                if (mainResult != null) {
                    val adapter = ResultsRecyclerViewAdapter(it, mainResult.results)
                    resultsRecyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    resultsRecyclerView?.adapter = adapter
                } else {
                    Toast.makeText(it, error.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}

}
