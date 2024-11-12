package com.example.kr_3_mobile

data class Ticket(
    val firstName: String,
    val lastName: String,
    val flight: String,
    val adultTicketCount: Int,
    val childTicketCount: Int,
    val ticketPrice: Double
) {
    fun totalCost(): Double = (adultTicketCount + childTicketCount) * ticketPrice
}
