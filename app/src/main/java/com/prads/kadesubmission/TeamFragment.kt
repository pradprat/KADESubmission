package com.prads.kadesubmission


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment

/**
 * A simple [Fragment] subclass.
 */
class TeamFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(): TeamFragment {
            return TeamFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

}
