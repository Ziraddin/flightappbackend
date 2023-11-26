package com.example.flightapp.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.data.relational.core.mapping.Table

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var email: String? = null,
    var password: String? = null,
    var paymentMethod: String? = null,
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    val transactions: List<Transaction>? = null
)

@Entity
@Table(name = "transaction")
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    var date: java.sql.Date? = null,
    var flightNumber: String? = null,
    var baggage: String? = null,
    var seatNumber: String? = null,
    @ManyToOne
    @JoinColumn(name = "userid")
    val user: User? = null
)

