package com.example.flightapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class FlightappApplication

fun main(args: Array<String>) {
    runApplication<FlightappApplication>(*args)
}

@RestController
class HelloController {
    @GetMapping("/")
    fun hello() = "Hello World!"
}
