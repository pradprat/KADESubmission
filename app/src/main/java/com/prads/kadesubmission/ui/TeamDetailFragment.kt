package com.prads.kadesubmission.ui


import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.ui.adapter.TeamAdapter
import com.prads.kadesubmission.ui.viewmodel.TeamViewModel
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.nestedScrollView
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TeamDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var teamViewModel: TeamViewModel

    private lateinit var league: LeagueLocal

    lateinit var rvListTeam: RecyclerView

    lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        league = arguments?.getParcelable()

        teamViewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamViewModel::class.java)


//        teamViewModel.loadTeams(league.id).observe(this.viewLifecycleOwner, Observer<List<Team>> {
//            //            textView.text = it
////            Log.d("---",it.toString())
//            teamAdapter.addData(it)
//        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = UI {

            nestedScrollView {
                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Jersey"
                                textSize = 12f //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            imageView {
                                imageResource = R.drawable.arsenal_jersey
                            }.lparams(width = dip(150), height = dip(150)) {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "League"
                                textSize = 12f //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text = "English Premier League"
                                textSize = 12f //sp
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Nickname"
                                textSize = 12f //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text = "Gunners, Gooners"
                                textSize = 12f //sp
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Established"
                                textSize = 12f //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text = "1892"
                                textSize = 12f //sp
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Stadium"
                                textSize = 12f //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text = "Emirates Stadium"
                                textSize = 12f //sp
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.CENTER
                            }
                            imageView {
                                scaleType = ImageView.ScaleType.CENTER_CROP
                                imageResource = R.drawable.arsenal_stadium
                            }.lparams(width = matchParent, height = dip(200)) {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text = "Location"
                                textSize = 12f //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text = "Holloway, London"
                                textSize = 12f //sp
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text =
                                    "The Emirates Stadium (known as Ashburton Grove prior to sponsorship) is a football stadium in Holloway, London, England, and the home of Arsenal Football Club. With a capacity of 60,272, the Emirates is the third-largest football stadium in England after Wembley and Old Trafford.In 1997, Arsenal explored the possibility of relocating to a new stadium, having been denied planning permission by Islington Council to expand its home ground of Highbury. After considering various options (including purchasing Wembley), the club bought an industrial and waste disposal estate in Ashburton Grove in 2000. A year later they won the council's approval to build a stadium on the site; manager Ars�ne Wenger described this as the biggest decision in Arsenals history since the board appointed Herbert Chapman. Relocation began in 2002, but financial difficulties delayed work until February 2004. Emirates Airline was later announced as the main sponsor for the stadium. Work was completed in 2006 at a cost of �390 million."
                                textAlignment = View.TEXT_ALIGNMENT_CENTER
                                textSize = 12f //sp
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                }.lparams(width = matchParent)
            }
        }.view

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_LEAGUE = "ARG_TEAM"
        @JvmStatic
        fun newInstance(): TeamDetailFragment {
            return TeamDetailFragment().apply {
                arguments = Bundle().apply {
                    //                    putInt(ARG_SECTION_NUMBER, sectionNumber)
//                    putParcelable(ARG_LEAGUE,league)
                }
            }
        }
    }
}
