package com.prads.kadesubmission.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.Event
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.ui.adapter.EventAdapter
import com.prads.kadesubmission.ui.viewmodel.EventViewModel
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.textView
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class TeamEventFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var eventViewModel: EventViewModel

    private lateinit var team: Team

    lateinit var rvListEvent: RecyclerView

    lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        team = arguments?.getParcelable(ARG_TEAM)!!

        eventViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(EventViewModel::class.java).apply {
                setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rvEvent: RecyclerView? = null
        val root = UI {

            linearLayout {
                id = R.id.constraintLayout
                textView {
                    id = R.id.section_label
                }
                rvEvent = recyclerView {
                    id = R.id.rv_list_events
                }.lparams(width = matchParent)
            }
        }.view
        eventViewModel.loadEventsFromTeam(team.idTeam!!)
            .observe(this.viewLifecycleOwner, Observer<List<Event>> {
                eventAdapter.addData(it)
            })

        eventAdapter = EventAdapter {
            Intent(this.context, EventDetailActivity::class.java).run {
                this.putExtra("TAG_EVENT", it)
                Log.d("---Team", it.toString())
                toast("kamu memilih " + it.strEvent)
                startActivity(this)
            }
        }

        rvListEvent = rvEvent!!

        rvListEvent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventAdapter
        }

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_TEAM = "ARG_TEAM"
        @JvmStatic
        fun newInstance(team: Team): TeamEventFragment {
            return TeamEventFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_TEAM, team)
                }
            }
        }
    }
}