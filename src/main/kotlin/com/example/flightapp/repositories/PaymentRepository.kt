package com.example.flightapp.repositories

import com.example.flightapp.dtos.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, Int>