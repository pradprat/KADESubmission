package com.prads.kadesubmission.data

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.data.source.local.EventFavorite
import com.prads.kadesubmission.data.source.local.TeamFavorite
import com.prads.kadesubmission.data.source.local.database
import com.prads.kadesubmission.data.source.remote.responses.TeamResponse
import com.prads.kadesubmission.utils.EspressoIdlingResource
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TeamRepository @Inject constructor(private var service: ApiService){

    fun getSearchTeam(query: String, leagueId: String): MutableLiveData<List<Team>> {
        EspressoIdlingResource.increment()
        var liveDataTeams = MutableLiveData<List<Team>>()
        var teams = ArrayList<Team>()

        service.getSearchTeams(query).enqueue(object : Callback<TeamResponse> {
            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    if (response.body()?.teams !== null) {
                        teams.addAll(response.body()!!.teams)
                        val eventsFiltered = teams.filter {
                            it.strSport == "Soccer" && it.idLeague == leagueId
                        }
                        liveDataTeams.postValue(eventsFiltered)
                        EspressoIdlingResource.decrement()
                    }
                }
            }
        })
        return liveDataTeams
    }

    fun getTeam(team_id:String): MutableLiveData<Team> {
        EspressoIdlingResource.increment()
        var liveDataTeam = MutableLiveData<Team>()
        var teams = ArrayList<Team>()

        service.getTeamById(team_id).enqueue(object : Callback<TeamResponse>{
            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful){
                    if (response.body()!=null){
                        teams.addAll(response.body()!!.teams)
                        liveDataTeam.postValue(teams.first())
                        EspressoIdlingResource.decrement()
                    }
                }
            }
        })
        return liveDataTeam
    }

    fun getAllTeam(leagueId: String): MutableLiveData<List<Team>> {
        EspressoIdlingResource.increment()
        var liveDataTeams = MutableLiveData<List<Team>>()
        var teams = ArrayList<Team>()

        service.getTeams(leagueId).enqueue(object : Callback<TeamResponse> {
            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        teams.addAll(response.body()!!.teams)
                        liveDataTeams.postValue(teams)
                        EspressoIdlingResource.decrement()
                    }
                }
            }
        })
        return liveDataTeams
    }

    fun getFavoriteTeams(context: Context): MutableLiveData<List<Team>> {
        EspressoIdlingResource.increment()
        val liveDataTeams = MutableLiveData<List<Team>>()
        val teams = ArrayList<Team>()
        context.database.use {
            val result = select(TeamFavorite.TABLE)
            val favorite = result.parseList(classParser<Team>())
            teams.addAll(favorite)
            liveDataTeams.value = teams
            EspressoIdlingResource.decrement()
        }
        return liveDataTeams
    }

    fun getIsFavoriteTeam(context: Context, teamId: String): MutableLiveData<Boolean> {
        EspressoIdlingResource.increment()
        val liveDatastatus = MutableLiveData<Boolean>()
        context.database.use {
            val result = select(TeamFavorite.TABLE)
                .whereArgs(
                    "(idTeam = {id})",
                    "id" to teamId
                )
            val favorite = result.parseList(classParser<Team>())
            liveDatastatus.value = favorite.isNotEmpty()
            EspressoIdlingResource.decrement()
        }
        return liveDatastatus
    }

    fun setAddFavoriteTeam(context: Context, team: Team): MutableLiveData<Boolean> {
        EspressoIdlingResource.increment()
        val liveDatastatus = MutableLiveData<Boolean>()
        try {
            context.database.use {
                insert(
                    TeamFavorite.TABLE,
                    TeamFavorite.idLeague to team.idLeague,
                    TeamFavorite.idSoccerXML to team.idSoccerXML,
                    TeamFavorite.idTeam to team.idTeam,
                    TeamFavorite.intFormedYear to team.intFormedYear,
                    TeamFavorite.intLoved to team.intLoved,
                    TeamFavorite.intStadiumCapacity to team.intStadiumCapacity,
                    TeamFavorite.strAlternate to team.strAlternate,
                    TeamFavorite.strCountry to team.strCountry,
                    TeamFavorite.strDescriptionCN to team.strDescriptionCN,
                    TeamFavorite.strDescriptionDE to team.strDescriptionDE,
                    TeamFavorite.strDescriptionEN to team.strDescriptionEN,
                    TeamFavorite.strDescriptionES to team.strDescriptionES,
                    TeamFavorite.strDescriptionFR to team.strDescriptionFR,
                    TeamFavorite.strDescriptionHU to team.strDescriptionHU,
                    TeamFavorite.strDescriptionIL to team.strDescriptionIL,
                    TeamFavorite.strDescriptionIT to team.strDescriptionIT,
                    TeamFavorite.strDescriptionJP to team.strDescriptionJP,
                    TeamFavorite.strDescriptionNL to team.strDescriptionNL,
                    TeamFavorite.strDescriptionNO to team.strDescriptionNO,
                    TeamFavorite.strDescriptionPL to team.strDescriptionPL,
                    TeamFavorite.strDescriptionPT to team.strDescriptionPT,
                    TeamFavorite.strDescriptionRU to team.strDescriptionRU,
                    TeamFavorite.strDescriptionSE to team.strDescriptionSE,
                    TeamFavorite.strDivision to team.strDivision,
                    TeamFavorite.strFacebook to team.strFacebook,
                    TeamFavorite.strGender to team.strGender,
                    TeamFavorite.strInstagram to team.strInstagram,
                    TeamFavorite.strKeywords to team.strKeywords,
                    TeamFavorite.strLeague to team.strLeague,
                    TeamFavorite.strLocked to team.strLocked,
                    TeamFavorite.strManager to team.strManager,
                    TeamFavorite.strRSS to team.strRSS,
                    TeamFavorite.strSport to team.strSport,
                    TeamFavorite.strStadium to team.strStadium,
                    TeamFavorite.strStadiumDescription to team.strStadiumDescription,
                    TeamFavorite.strStadiumLocation to team.strStadiumLocation,
                    TeamFavorite.strStadiumThumb to team.strStadiumThumb,
                    TeamFavorite.strTeam to team.strTeam,
                    TeamFavorite.strTeamBadge to team.strTeamBadge,
                    TeamFavorite.strTeamBanner to team.strTeamBanner,
                    TeamFavorite.strTeamFanart1 to team.strTeamFanart1,
                    TeamFavorite.strTeamFanart2 to team.strTeamFanart2,
                    TeamFavorite.strTeamFanart3 to team.strTeamFanart3,
                    TeamFavorite.strTeamFanart4 to team.strTeamFanart4,
                    TeamFavorite.strTeamJersey to team.strTeamJersey,
                    TeamFavorite.strTeamLogo to team.strTeamLogo,
                    TeamFavorite.strTeamShort to team.strTeamShort,
                    TeamFavorite.strTwitter to team.strTwitter,
                    TeamFavorite.strWebsite to team.strWebsite,
                    TeamFavorite.strYoutube to team.strYoutube
                )
            }
            liveDatastatus.value = true
            EspressoIdlingResource.decrement()
        } catch (e: SQLiteConstraintException) {
            liveDatastatus.value = false
            EspressoIdlingResource.decrement()
        }
        return liveDatastatus
    }

    fun setDeleteFavoriteTeam(context: Context, team: Team): MutableLiveData<Boolean> {
        EspressoIdlingResource.increment()
        val liveDatastatus = MutableLiveData<Boolean>()
        val idTeam = "" + team.idTeam
        try {
            context.database.use {
                delete(
                    EventFavorite.TABLE, "(idTeam = {id})",
                    "id" to idTeam
                )
            }
            liveDatastatus.value = true
            EspressoIdlingResource.decrement()
        } catch (e: SQLiteConstraintException) {
            liveDatastatus.value = false
            EspressoIdlingResource.decrement()
        }
        return liveDatastatus
    }

}