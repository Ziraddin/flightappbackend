package com.example.flightapp.services

import com.example.flightapp.dtos.Flight
import com.example.flightapp.repositories.FlightRepository
import org.springframework.stereotype.Service

@Service
class FlightService(val flightRepository: FlightRepository) {
    fun getFlights(arrival: String, departure: String, departureTime: String, arrivalTime: String) =
        flightRepository.findByArrivalAndDepartureAndDepartureTimeAndArrivalTime(
            arrival,
            departure,
            departureTime,
            arrivalTime
        )

    fun getFlights(arrival: String, departure: String, departureTime: String) =
        flightRepository.findByArrivalAndDepartureAndDepartureTime(
            arrival,
            departure,
            departureTime
        )

    fun getAllFlights(): List<Flight> {
        return flightRepository.findAll().toList()
    }

    fun getFlightById(id: Int): Flight {
        return flightRepository.findById(id).get()
    }

    fun addFlight(flight: Flight): Flight {
        return flightRepository.save(flight)
    }

    fun updateFlight(id: Int, flight: Flight): Flight {
        val flightToUpdate = flightRepository.findById(id).get()
        flightToUpdate.apply {
            arrival = flight.arrival ?: arrival
            departure = flight.departure ?: departure
            departureTime = flight.departureTime ?: departureTime
            arrivalTime = flight.arrivalTime ?: arrivalTime
            price = flight.price ?: price
        }
        return flightRepository.save(flightToUpdate)
    }

    fun deleteFlight(id: Int) {
        flightRepository.deleteById(id)
    }
}