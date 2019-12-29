package com.prads.kadesubmission.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.Event
import com.prads.kadesubmission.data.EventRepository

class EventViewModel constructor(private val eventRepository: EventRepository) : ViewModel() {

    private val _index = MutableLiveData<Int>()

    fun loadEvents(league_id:String) : MutableLiveData<List<Event>> = eventRepository.getAllEvents(
        _index.value!!,league_id)

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun searchEvents(query:String) : MutableLiveData<List<Event>> = eventRepository.getSearchEvents(query)

    fun favoriteEvents(context: Context) : MutableLiveData<List<Event>> = eventRepository.getFavoriteEvents(context)
}