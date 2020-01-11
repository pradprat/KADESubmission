package com.prads.kadesubmission.ui


import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.Team
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

    lateinit var team: Team

    lateinit var ivJersey: ImageView
    lateinit var tvLeague: TextView
    lateinit var tvNickname: TextView
    lateinit var tvEstablished: TextView
    lateinit var tvStadiumName: TextView
    lateinit var ivStadiumSnap: ImageView
    lateinit var tvStadiumLocation: TextView
    lateinit var tvStadiumDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        team = arguments?.getParcelable(ARG_TEAM)!!
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
                        elevation = dip(4).toFloat()
                        radius = dip(8).toFloat()
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Jersey"
                                textSize = sp(6).toFloat() //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            ivJersey = imageView {
                                id = R.id.iv_team_detail_jersey
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
                        elevation = dip(4).toFloat()
                        radius = dip(8).toFloat()
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "League"
                                textSize = sp(6).toFloat() //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            tvLeague = textView {
                                id = R.id.tv_team_detail_league
                                text = "English Premier League"
                                textSize = sp(6).toFloat() //sp
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                    cardView {
                        elevation = dip(4).toFloat()
                        radius = dip(8).toFloat()
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Nickname"
                                textSize = sp(6).toFloat() //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            tvNickname = textView {
                                id = R.id.tv_team_detail_nickname
                                text = "Gunners, Gooners"
                                textSize = sp(6).toFloat() //sp
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                    cardView {
                        elevation = dip(4).toFloat()
                        radius = dip(8).toFloat()
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Established"
                                textSize = sp(6).toFloat() //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            tvEstablished = textView {
                                id = R.id.tv_team_detail_established
                                text = "1892"
                                textSize = sp(6).toFloat() //sp
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                    cardView {
                        elevation = dip(4).toFloat()
                        radius = dip(8).toFloat()
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            textView {
                                text = "Stadium"
                                textSize = sp(6).toFloat() //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            tvStadiumName = textView {
                                id = R.id.tv_team_detail_stadium_name
                                text = "Emirates Stadium"
                                textSize = sp(6).toFloat() //sp
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            ivStadiumSnap = imageView {
                                id = R.id.iv_team_detail_stadium_snap
                                scaleType = ImageView.ScaleType.CENTER_CROP
                                imageResource = R.drawable.arsenal_stadium
                            }.lparams(width = matchParent, height = dip(200)) {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            textView {
                                text = "Location"
                                textSize = sp(6).toFloat() //sp
                                setTypeface(typeface, Typeface.BOLD)
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            tvStadiumLocation = textView {
                                id = R.id.tv_team_detail_stadium_location
                                text = "Holloway, London"
                                textSize = sp(6).toFloat() //sp
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                            tvStadiumDesc = textView {
                                id = R.id.tv_team_detail_stadium_desc
                                text =
                                    "The Emirates Stadium (known as Ashburton Grove prior to sponsorship) is a football stadium in Holloway, London, England, and the home of Arsenal Football Club. With a capacity of 60,272, the Emirates is the third-largest football stadium in England after Wembley and Old Trafford.In 1997, Arsenal explored the possibility of relocating to a new stadium, having been denied planning permission by Islington Council to expand its home ground of Highbury. After considering various options (including purchasing Wembley), the club bought an industrial and waste disposal estate in Ashburton Grove in 2000. A year later they won the council's approval to build a stadium on the site; manager Ars�ne Wenger described this as the biggest decision in Arsenals history since the board appointed Herbert Chapman. Relocation began in 2002, but financial difficulties delayed work until February 2004. Emirates Airline was later announced as the main sponsor for the stadium. Work was completed in 2006 at a cost of �390 million."
                                textAlignment = View.TEXT_ALIGNMENT_CENTER
                                textSize = sp(6).toFloat() //sp
                            }.lparams {
                                margin = dip(8)
                                gravity = Gravity.CENTER
                            }
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        margin = dip(4)
                    }
                }.lparams(width = matchParent)
            }
        }.view

        Glide.with(this).load(team.strTeamJersey).into(ivJersey)
        tvLeague.text = team.strLeague
        tvNickname.text = team.strAlternate
        tvEstablished.text = team.intFormedYear
        tvStadiumName.text = team.strStadium
        Glide.with(this).load(team.strStadiumThumb).into(ivStadiumSnap)
        tvStadiumLocation.text = team.strStadiumLocation
        tvStadiumDesc.text = team.strStadiumDescription



        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_TEAM = "ARG_TEAM"
        @JvmStatic
        fun newInstance(team: Team): TeamDetailFragment {
            return TeamDetailFragment().apply {
                arguments = Bundle().apply {
                    //                                        putInt(ARG_SECTION_NUMBER, sectionNumber)
                    putParcelable(ARG_TEAM, team)
                }
            }
        }
    }
}
