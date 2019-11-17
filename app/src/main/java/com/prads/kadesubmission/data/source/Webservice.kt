package com.example.subm1jetpackmovieskuy.data.source

import com.prads.kadesubmission.data.EventResponse
import com.prads.kadesubmission.data.LeagueResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {
    @GET("lookupleague.php")
    fun getLeagueById(@Query("id") leagueId:String): Call<LeagueResponse>

    @GET("eventsnextleague.php")
    fun getNextEvents(@Query("id") leagueId:String): Call<EventResponse>

    @GET("eventspastleague.php?id={idLeague}")
    fun getPastEvents(@Query("id") leagueId:String): Call<EventResponse>

    @GET("lookupevent.php?id={idEvent}")
    fun getEventById(@Query("id") eventId:String): Call<EventResponse>

    @GET("searchevents.php?e={query}")
    fun getEventByName(@Query("e") eventName:String): Call<EventResponse>
}