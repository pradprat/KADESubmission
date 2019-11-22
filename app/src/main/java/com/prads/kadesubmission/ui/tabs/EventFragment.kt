package com.prads.kadesubmission.ui.tabs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.Event
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.data.LeagueDummy
import com.prads.kadesubmission.ui.EventAdapter
import com.prads.kadesubmission.ui.LeagueAdapter
import dagger.android.support.DaggerFragment
import okhttp3.internal.notify
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.find
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class EventFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var eventViewModel: EventViewModel

    private lateinit var league: LeagueDummy

    lateinit var rvListEvent: RecyclerView

    lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        league = arguments?.getParcelable<LeagueDummy>(ARG_LEAGUE)!!

        eventViewModel = ViewModelProviders.of(this,viewModelFactory).get(EventViewModel::class.java).apply {
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

            linearLayout() {
                id = R.id.constraintLayout
                textView {
                    id = R.id.section_label
                    text="ngnetotoadkljasd"
                }
                rvEvent = recyclerView(){
                    id = R.id.rv_list_events
                }
            }
        }.view
        val textView: TextView = root.findViewById(R.id.section_label)
        eventViewModel.loadLeagues(league.id).observe(this.viewLifecycleOwner, Observer<List<Event>> {
//            textView.text = it
//            Log.d("---",it.toString())
            eventAdapter.addData(it)
        })

        eventAdapter = EventAdapter {
            TODO()
//            Intent(this, LeagueDetailActivity::class.java).run {
//                this.putExtra("TAG_LEAGUE", it)
//                toast("kamu memilih " + it.name)
//                startActivity(this)
//            }
        }

        rvListEvent = rvEvent!!

        rvListEvent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventAdapter
//            info("recyclerview created")
        }

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_LEAGUE = "ARG_LEAGUE"
        @JvmStatic
        fun newInstance(sectionNumber: Int,league: LeagueDummy): EventFragment {
            return EventFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                    putParcelable(ARG_LEAGUE,league)
                }
            }
        }
    }
}