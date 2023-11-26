package com.example.flightapp.repositories

import com.example.flightapp.dtos.Transaction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : CrudRepository<Transaction, Int> {
    fun findByUserId(userId: Int): List<Transaction>
}