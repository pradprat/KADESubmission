package com.prads.kadesubmission.ui.tabs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.Event
import com.prads.kadesubmission.data.EventRepository

class EventViewModel constructor(private val eventRepository: EventRepository) : ViewModel() {

    private val _index = MutableLiveData<Int>()

    fun loadLeagues(league_id:String) : MutableLiveData<List<Event>> = eventRepository.getAllEvents(
        _index.value!!,league_id)

    fun setIndex(index: Int) {
        _index.value = index
    }
}