package com.example.flightapp.controllers

import com.example.flightapp.dtos.Transaction
import com.example.flightapp.services.TransactionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transactions")
class TransactionController(val transactionService: TransactionService) {

    @GetMapping("/getAllTransactions")
    fun getAllTransactions() = transactionService.getAllTransactions()

    @GetMapping("/getTransactionById")
    fun getTransactionById(@RequestParam id: Int) = transactionService.getTransactionById(id)

    @GetMapping("/getTransactionsByUserId")
    fun getTransactionsByUserId(@RequestParam userid: Int) = transactionService.getTransactionsByUserId(userid)

    @PostMapping("/addTransaction")
    fun createTransaction(@RequestBody transaction: Transaction) = transactionService.createTransaction(transaction)

    @PutMapping("/updateTransaction")
    fun updateTransaction(@RequestParam id: Int, @RequestBody transaction: Transaction) =
        transactionService.updateTransaction(id, transaction)

    @DeleteMapping("/deleteTransaction")
    fun deleteTransaction(@RequestParam id: Int) = transactionService.deleteTransaction(id)
}