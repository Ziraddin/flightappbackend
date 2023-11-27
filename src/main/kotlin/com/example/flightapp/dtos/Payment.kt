package com.example.flightapp.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "payment")
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    var paymentType: String? = null,
    @OneToMany(mappedBy = "payment")
    @JsonIgnore
    val transactions: List<Transaction>? = null
)