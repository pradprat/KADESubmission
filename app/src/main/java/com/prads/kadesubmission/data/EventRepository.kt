package com.prads.kadesubmission.data

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import com.prads.kadesubmission.data.model.Event
import com.prads.kadesubmission.data.model.EventSearchResponse
import com.prads.kadesubmission.data.source.local.EventFavorite
import com.prads.kadesubmission.data.source.local.database
import com.prads.kadesubmission.data.source.remote.responses.EventResponse
import com.prads.kadesubmission.utils.EspressoIdlingResource
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EventRepository @Inject constructor(private var service: ApiService) {

    fun getAllEvents(page:Int,league_id:String): MutableLiveData<List<Event>> {
        if (page==1){
            return getAllPastEvents(league_id)
        }else{
            return getAllNextEvents(league_id)
        }
    }

    fun getAllPastEvents(league_id:String): MutableLiveData<List<Event>> {
        EspressoIdlingResource.increment()
        var liveDataEvents = MutableLiveData<List<Event>>()
        var events = ArrayList<Event>()
        service.getPastEvents(league_id).enqueue(object : Callback<EventResponse> {
            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if (response.isSuccessful){
                    if (response.body()!==null){
                        events.addAll(response.body()!!.events)
                        liveDataEvents.postValue(events)
                        EspressoIdlingResource.decrement()
                    }
                }
            }
        })
        return liveDataEvents
    }
    fun getAllNextEvents(league_id:String): MutableLiveData<List<Event>>{
        EspressoIdlingResource.increment()
        var liveDataEvents = MutableLiveData<List<Event>>()
        var events = ArrayList<Event>()
        service.getNextEvents(league_id).enqueue(object : Callback<EventResponse> {
            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if (response.isSuccessful){
                    if (response.body()?.events!==null){
                        events.addAll(response.body()!!.events)
                        liveDataEvents.postValue(events)
                        EspressoIdlingResource.decrement()
                    }
                }
            }
        })
        return liveDataEvents
    }

    fun getSearchEvents(query:String,league_id: String): MutableLiveData<List<Event>>{
        EspressoIdlingResource.increment()
        val liveDataEvents = MutableLiveData<List<Event>>()
        val events = ArrayList<Event>()
        service.getSearchEvent(query).enqueue(object : Callback<EventSearchResponse> {
            override fun onFailure(call: Call<EventSearchResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<EventSearchResponse>, response: Response<EventSearchResponse>) {
                if (response.isSuccessful){
                    if (response.body()?.event!==null){
                        events.addAll(response.body()!!.event)
                        val eventsFiltered = events.filter {
                            it.strSport == "Soccer" &&
                            it.idLeague == league_id
                        }
                        liveDataEvents.postValue(eventsFiltered)
                        EspressoIdlingResource.decrement()
                    }
                }
            }

        })
        return liveDataEvents
    }

    fun getFavoriteEvents(context: Context): MutableLiveData<List<Event>>{
        EspressoIdlingResource.increment()
        val liveDataEvents = MutableLiveData<List<Event>>()
        val events = ArrayList<Event>()
        context.database.use {
            val result = select(EventFavorite.TABLE)
            val favorite = result.parseList(classParser<Event>())
            events.addAll(favorite)
            liveDataEvents.value = events
            EspressoIdlingResource.decrement()
        }
        return liveDataEvents
    }

    fun getIsFavoriteEvent(context: Context, eventId: String): MutableLiveData<Boolean> {
        EspressoIdlingResource.increment()
        val liveDatastatus = MutableLiveData<Boolean>()
        context.database.use {
            val result = select(EventFavorite.TABLE)
                .whereArgs(
                    "(idEvent = {id})",
                    "id" to eventId
                )
            val favorite = result.parseList(classParser<Event>())
            liveDatastatus.value = favorite.isNotEmpty()
            EspressoIdlingResource.decrement()
        }
        return liveDatastatus
    }

    fun setAddFavoriteEvent(context: Context, event: Event): MutableLiveData<Boolean> {
        EspressoIdlingResource.increment()
        val liveDatastatus = MutableLiveData<Boolean>()
        try {
            context.database.use {
                insert(
                    EventFavorite.TABLE,
                    EventFavorite.dateEvent to event.dateEvent,
                    EventFavorite.dateEventLocal to event.dateEventLocal,
                    EventFavorite.idAwayTeam to event.idAwayTeam,
                    EventFavorite.idEvent to event.idEvent,
                    EventFavorite.idHomeTeam to event.idHomeTeam,
                    EventFavorite.idLeague to event.idLeague,
                    EventFavorite.idSoccerXML to event.idSoccerXML,
                    EventFavorite.intAwayScore to event.intAwayScore,
                    EventFavorite.intAwayShots to event.intAwayShots,
                    EventFavorite.intHomeScore to event.intHomeScore,
                    EventFavorite.intHomeShots to event.intHomeShots,
                    EventFavorite.intRound to event.intRound,
                    EventFavorite.intSpectators to event.intSpectators,
                    EventFavorite.strAwayFormation to event.strAwayFormation,
                    EventFavorite.strAwayGoalDetails to event.strAwayGoalDetails,
                    EventFavorite.strAwayLineupDefense to event.strAwayLineupDefense,
                    EventFavorite.strAwayLineupForward to event.strAwayLineupForward,
                    EventFavorite.strAwayLineupGoalkeeper to event.strAwayLineupGoalkeeper,
                    EventFavorite.strAwayLineupMidfield to event.strAwayLineupMidfield,
                    EventFavorite.strAwayLineupSubstitutes to event.strAwayLineupSubstitutes,
                    EventFavorite.strAwayRedCards to event.strAwayRedCards,
                    EventFavorite.strAwayTeam to event.strAwayTeam,
                    EventFavorite.strAwayYellowCards to event.strAwayYellowCards,
                    EventFavorite.strBanner to event.strBanner,
                    EventFavorite.strCircuit to event.strCircuit,
                    EventFavorite.strCity to event.strCity,
                    EventFavorite.strCountry to event.strCountry,
                    EventFavorite.strDate to event.strDate,
                    EventFavorite.strDescriptionEN to event.strDescriptionEN,
                    EventFavorite.strEvent to event.strEvent,
                    EventFavorite.strEventAlternate to event.strEventAlternate,
                    EventFavorite.strFanart to event.strFanart,
                    EventFavorite.strFilename to event.strFilename,
                    EventFavorite.strHomeFormation to event.strHomeFormation,
                    EventFavorite.strHomeGoalDetails to event.strHomeGoalDetails,
                    EventFavorite.strHomeLineupDefense to event.strHomeLineupDefense,
                    EventFavorite.strHomeLineupForward to event.strHomeLineupForward,
                    EventFavorite.strHomeLineupGoalkeeper to event.strHomeLineupGoalkeeper,
                    EventFavorite.strHomeLineupMidfield to event.strHomeLineupMidfield,
                    EventFavorite.strHomeLineupSubstitutes to event.strHomeLineupSubstitutes,
                    EventFavorite.strHomeRedCards to event.strHomeRedCards,
                    EventFavorite.strHomeTeam to event.strHomeTeam,
                    EventFavorite.strHomeYellowCards to event.strHomeYellowCards,
                    EventFavorite.strLeague to event.strLeague,
                    EventFavorite.strLocked to event.strLocked,
                    EventFavorite.strMap to event.strMap,
                    EventFavorite.strPoster to event.strPoster,
                    EventFavorite.strResult to event.strResult,
                    EventFavorite.strSeason to event.strSeason,
                    EventFavorite.strSport to event.strSport,
                    EventFavorite.strTVStation to event.strTVStation,
                    EventFavorite.strThumb to event.strThumb,
                    EventFavorite.strTime to event.strTime,
                    EventFavorite.strTimeLocal to event.strTimeLocal,
                    EventFavorite.strTweet1 to event.strTweet1,
                    EventFavorite.strTweet2 to event.strTweet2,
                    EventFavorite.strTweet3 to event.strTweet3,
                    EventFavorite.strVideo to event.strVideo
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

    fun setDeleteFavoriteEvent(context: Context, event: Event): MutableLiveData<Boolean> {
        EspressoIdlingResource.increment()
        val liveDatastatus = MutableLiveData<Boolean>()
        val idEvent = "" + event.idEvent
        try {
            context.database.use {
                delete(
                    EventFavorite.TABLE, "(idEvent = {id})",
                    "id" to idEvent
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