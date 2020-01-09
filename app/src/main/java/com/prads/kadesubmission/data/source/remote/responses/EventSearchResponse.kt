package com.prads.kadesubmission.data.source.remote.responses

import com.prads.kadesubmission.data.model.Event

data class EventSearchResponse(
    val event: List<Event>
)