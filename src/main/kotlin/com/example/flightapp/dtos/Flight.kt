package com.example.flightapp.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.data.relational.core.mapping.Table
@Entity
@Table(name = "flight")
data class Flight(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val flightNumber: String? = null,
    var departure: String? = null,
    var arrival: String? = null,
    var departureTime: String? = null,
    var arrivalTime: String? = null,
    var price: Double? = null,
    val company: String? = null,
    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    val transactions: List<Transaction>? = null
)