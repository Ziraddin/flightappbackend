package com.example.flightapp.services

import com.example.flightapp.dtos.User
import com.example.flightapp.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun getAllUsers(): List<User> {
        return userRepository.findAll().toList()
    }

    fun getUserById(id: Int): User {
        return userRepository.findById(id).get()
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun updateUser(id: Int, user: User): User {
        val userToUpdate = userRepository.findById(id).get()
        userToUpdate.apply {
            firstname = user.firstname ?: firstname
            lastname = user.lastname ?: lastname
            email = user.email ?: email
            password = user.password ?: password
            payment?.paymentType = user.payment?.paymentType
        }
        return userRepository.save(userToUpdate)
    }

    fun deleteUser(id: Int) {
        userRepository.deleteById(id)
    }
}