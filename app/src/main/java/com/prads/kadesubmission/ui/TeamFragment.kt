package com.prads.kadesubmission.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.ui.adapter.TeamAdapter
import com.prads.kadesubmission.ui.viewmodel.TeamViewModel
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TeamFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var teamViewModel: TeamViewModel

    private lateinit var league: LeagueLocal

    lateinit var rvListTeam: RecyclerView

    lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        league = arguments?.getParcelable(ARG_LEAGUE)!!

        teamViewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamViewModel::class.java)
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
                    id = R.id.rv_list_teams
                }.lparams(width = matchParent)
            }
        }.view
        teamViewModel.loadTeams(league.id).observe(this.viewLifecycleOwner, Observer<List<Team>> {
            //            textView.text = it
//            Log.d("---",it.toString())
            teamAdapter.addData(it)
        })

        teamAdapter = TeamAdapter {
            //            Intent(this.context, TeamDetailActivity::class.java).run {
//                this.putExtra("TAG_TEAM", it)
//                Log.d("---Team", it.toString())
//                toast("kamu memilih " + it.strEvent)
//                startActivity(this)
//            }
        }

        rvListTeam = rvEvent!!

        rvListTeam.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = teamAdapter
//            info("recyclerview created")
        }

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_LEAGUE = "ARG_LEAGUE"
        @JvmStatic
        fun newInstance(league: LeagueLocal): TeamFragment {
            return TeamFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_LEAGUE, league)
                }
            }
        }
    }

}
