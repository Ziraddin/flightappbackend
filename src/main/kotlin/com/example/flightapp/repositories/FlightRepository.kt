package com.example.flightapp.repositories

import com.example.flightapp.dtos.Flight
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FlightRepository : CrudRepository<Flight, Int> {
    //This method is for one way
    fun findByArrivalAndDepartureAndDepartureTimeContains(
        arrival: String,
        departure: String,
        departureTime: String
    ): List<Flight>

    // This method is for round trip
    fun findByArrivalAndDepartureAndDepartureTimeAndArrivalTimeContains(
        arrival: String,
        departure: String,
        departureTime: String,
        arrivalTime: String
    ): List<Flight>
}