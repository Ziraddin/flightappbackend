package com.example.flightapp.controllers

import com.example.flightapp.dtos.Flight
import com.example.flightapp.services.FlightService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/flights")
class FlightController(val flightService: FlightService) {

    @GetMapping("/getFlightsByArrivalDepartureAndDepartureTime")
    fun getFlights(
        @RequestParam arrival: String,
        @RequestParam departure: String,
        @RequestParam departureTime: String
    ) =
        flightService.getFlights(arrival, departure, departureTime)

    @GetMapping("/getFlightsByArrivalDepartureAndDepartureTimeArrivalTime")
    fun getFlights(
        @RequestParam arrival: String,
        @RequestParam departure: String,
        @RequestParam departureTime: String,
        @RequestParam arrivalTime: String
    ) = flightService.getFlights(arrival, departure, departureTime, arrivalTime)

    @GetMapping("/getAllFlights")
    fun getAllFlights() = flightService.getAllFlights()

    @GetMapping("/getFlightById")
    fun getFlightById(@RequestParam id: Int) = flightService.getFlightById(id)

    @PostMapping("/addFlight")
    fun addFlight(@RequestBody flight: Flight) = flightService.addFlight(flight)

    @PutMapping("/updateFlight")
    fun updateFlight(@RequestParam id: Int, @RequestBody flight: Flight) = flightService.updateFlight(id, flight)

    @DeleteMapping("/deleteFlight")
    fun deleteFlight(@RequestParam id: Int) = flightService.deleteFlight(id)
}