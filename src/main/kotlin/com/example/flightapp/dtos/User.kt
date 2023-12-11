package com.example.flightapp.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.data.relational.core.mapping.Table

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var firstname: String? = null,
    var lastname: String? = null,
    var email: String? = null,
    @JsonIgnore
    var password: String? = null,
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    val transactions: List<Transaction>? = null,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "paymentid")
    var payment: Payment? = null
)
