package com.example.flightapp.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "payment")
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var paymentType: String? = null,
    @OneToMany(mappedBy = "payment")
    @JsonIgnore
    val users: List<User>? = null
)