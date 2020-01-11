package com.prads.kadesubmission.data

import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.data.source.remote.responses.TeamResponse
import com.prads.kadesubmission.utils.EspressoIdlingResource
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
}