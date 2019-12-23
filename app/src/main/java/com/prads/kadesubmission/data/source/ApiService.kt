package com.example.subm1jetpackmovieskuy.data.source

import com.prads.kadesubmission.data.EventResponse
import com.prads.kadesubmission.data.LeagueResponse
import com.prads.kadesubmission.data.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("lookupleague.php")
    fun getLeagueById(@Query("id") leagueId:String): Call<LeagueResponse>

    @GET("eventsnextleague.php")
    fun getNextEvents(@Query("id") leagueId:String): Call<EventResponse>

    @GET("eventspastleague.php")
    fun getPastEvents(@Query("id") leagueId:String): Call<EventResponse>

    @GET("lookupteam.php")
    fun getTeamById(@Query("id") teamId:String): Call<TeamResponse>

    @GET("lookupevent.php")
    fun getEventById(@Query("id") eventId:String): Call<EventResponse>

    @GET("searchevents.php")
    fun getSearchEvent(@Query("e") eventName:String): Call<EventResponse>
}