package com.example.kr_3_mobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicketViewModel : ViewModel() {
    private val _tickets = MutableLiveData<List<Ticket>>(emptyList())
    val tickets: LiveData<List<Ticket>> get() = _tickets

    fun addTicket(ticket: Ticket) {
        _tickets.value = _tickets.value?.plus(ticket)
    }

    fun getTotalCost(): Double {
        return _tickets.value?.sumOf { it.totalCost() } ?: 0.0
    }

    fun getAdultTicketCount(): Int {
        return _tickets.value?.sumOf { it.adultTicketCount } ?: 0
    }

    fun getChildTicketCount(): Int {
        return _tickets.value?.sumOf { it.childTicketCount } ?: 0
    }
}
