package com.example.flightapp.dtos

import jakarta.persistence.*
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Entity
@Table(name = "transaction")
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var date: Date? = null,
    var baggage: String? = null,
    var seatNumber: String? = null,
    @ManyToOne
    @JoinColumn(name = "userid")
    val user: User,
    @ManyToOne
    @JoinColumn(name = "flightid")
    val flight: Flight,
)