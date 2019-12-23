package com.prads.kadesubmission.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.ApiService
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
                    }
                }
            }
        })
        return liveDataEvents
    }
    fun getAllNextEvents(league_id:String): MutableLiveData<List<Event>>{
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
                    }
                }
            }
        })
        return liveDataEvents
    }

    fun getSearchEvents(query:String): MutableLiveData<List<Event>>{
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
                            it.strSport == "Soccer"
                        }
                        liveDataEvents.postValue(eventsFiltered)
                    }
                }
            }

        })
        return liveDataEvents
    }
}