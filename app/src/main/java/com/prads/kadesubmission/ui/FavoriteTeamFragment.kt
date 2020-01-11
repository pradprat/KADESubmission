package com.prads.kadesubmission.ui


import android.content.Intent
import android.os.Bundle
import android.util.Log
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
class FavoriteTeamFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var teamViewModel: TeamViewModel

    lateinit var rvListTeam: RecyclerView

    lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        context?.let {
            teamViewModel.favoriteTeams(it).observe(this.viewLifecycleOwner, Observer<List<Team>> {
                //            textView.text = it
                //            Log.d("---",it.toString())
                teamAdapter.addData(it)
            })
        }

        teamAdapter = TeamAdapter {
            Intent(this.context, TeamDetailActivity::class.java).run {
                this.putExtra("TAG_TEAM", it)
                Log.d("---team", it.toString())
                startActivity(this)
            }
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

        @JvmStatic
        fun newInstance(): FavoriteTeamFragment {
            return FavoriteTeamFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

}
