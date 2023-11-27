package com.example.flightapp.services

import com.example.flightapp.dtos.Payment
import com.example.flightapp.repositories.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(val paymentRepository: PaymentRepository) {
    fun getPaymentTypes() = paymentRepository.findAll().toList()

    fun getPaymentType(id: Int) = paymentRepository.findById(id)

    fun addPaymentType(paymentType: Payment) = paymentRepository.save(paymentType)

    fun updatePaymentType(id: Int, payment: Payment): Payment {
        val paymentToUpdate = paymentRepository.findById(id).get()
        paymentToUpdate.apply {
            paymentType = payment.paymentType ?: paymentType
        }
        return paymentRepository.save(paymentToUpdate)
    }

    fun deletePaymentType(id: Int) = paymentRepository.deleteById(id)
}