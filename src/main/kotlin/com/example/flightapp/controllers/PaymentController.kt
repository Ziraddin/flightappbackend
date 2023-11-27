package com.example.flightapp.controllers

import com.example.flightapp.dtos.Payment
import com.example.flightapp.services.PaymentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentController(val paymentService: PaymentService) {
    @GetMapping("/getAllPayments")
    fun getAllPayments() = paymentService.getPaymentTypes()

    @GetMapping("/getPaymentById")
    fun getPaymentById(@RequestParam id: Int) = paymentService.getPaymentType(id)

    @PostMapping("/addPaymentType")
    fun addPaymentType(@RequestBody paymentType: Payment) = paymentService.addPaymentType(paymentType)

    @PutMapping("/updatePaymentType")
    fun updatePaymentType(@RequestParam id: Int, @RequestBody paymentType: Payment) =
        paymentService.updatePaymentType(id, paymentType)

    @DeleteMapping("/deletePaymentType")
    fun deletePaymentType(@RequestParam id: Int) = paymentService.deletePaymentType(id)
}