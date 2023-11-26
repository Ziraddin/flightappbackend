package com.example.flightapp.repositories

import com.example.flightapp.dtos.Flight
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FlightRepository : CrudRepository<Flight, Int> {
    //This method is for one way
    fun findByArrivalAndDepartureAndDepartureTime(
        arrival: String,
        departure: String,
        departureTime: String
    ): List<Flight>

    //This method is for round trip
    fun findByArrivalAndDepartureAndDepartureTimeAndArrivalTime(
        arrival: String,
        departure: String,
        departureTime: String,
        arrivalTime: String
    ): List<Flight>
}