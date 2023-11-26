package com.example.flightapp.services

import com.example.flightapp.dtos.Transaction
import com.example.flightapp.repositories.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(val transactionRepository: TransactionRepository) {
    fun getAllTransactions(): List<Transaction> {
        return transactionRepository.findAll().toList()
    }

    fun getTransactionById(id: Int): Transaction {
        return transactionRepository.findById(id).get()
    }

    fun createTransaction(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction)
    }

    fun updateTransaction(id: Int, transaction: Transaction): Transaction {
        val transactionToUpdate = transactionRepository.findById(id).get()
        transactionToUpdate.apply {
            date = transaction.date
            flightNumber = transaction.flightNumber
            baggage = transaction.baggage
            seatNumber = transaction.seatNumber
        }
        return transactionRepository.save(transactionToUpdate)
    }

    fun getTransactionsByUserId(userId: Int): List<Transaction> {
        return transactionRepository.findByUserId(userId)
    }

    fun deleteTransaction(id: Int) {
        transactionRepository.deleteById(id)
    }
}