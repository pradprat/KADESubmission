package com.prads.kadesubmission.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.prads.kadesubmission.data.EventRepository
import com.prads.kadesubmission.data.model.Event
import com.prads.kadesubmission.data.model.EventDummy
import com.prads.kadesubmission.mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class EventViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var eventRepository: EventRepository

    lateinit var eventViewModel: EventViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        eventViewModel = EventViewModel(eventRepository)
    }

    @Test
    fun loadNextEvents() {
        eventViewModel.setIndex(0)
        val fakeEvent = EventDummy().getDummyNextEvents()
        val events = MutableLiveData<List<Event>>()
        events.value = fakeEvent
        `when`(eventViewModel.loadEvents("123"))
            .thenReturn(events)
        val observer: Observer<List<Event>> = mock()
        eventViewModel.loadEvents("123").observeForever(observer)
        verify(observer).onChanged(events.value)
    }

    @Test
    fun loadPastEvents() {
        eventViewModel.setIndex(1)
        val fakeEvent = EventDummy().getDummyPastEvents()
        val events = MutableLiveData<List<Event>>()
        events.value = fakeEvent
        `when`(eventViewModel.loadEvents("123"))
            .thenReturn(events)
        val observer: Observer<List<Event>> = mock()
        eventViewModel.loadEvents("123").observeForever(observer)
        verify(observer).onChanged(events.value)
    }

    @Test
    fun searchEvents() {
        eventViewModel.setIndex(1)
        val fakeEvent = EventDummy().getDummySearchEvents()
        val events = MutableLiveData<List<Event>>()
        events.value = fakeEvent
        `when`(eventViewModel.searchEvents("chelsea"))
            .thenReturn(events)
        val observer: Observer<List<Event>> = mock()
        eventViewModel.searchEvents("chelsea").observeForever(observer)
        verify(observer).onChanged(events.value)
    }
}