package com.example.flightapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightappApplication

fun main(args: Array<String>) {
    runApplication<FlightappApplication>(*args)
}
