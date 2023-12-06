package com.example.flightapp.services

import com.example.flightapp.dtos.User
import com.example.flightapp.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun getAllUsers(): List<User> {
        return userRepository.findAll().toList()
    }

    fun getUserByFirstname(firstname: String): List<User> {
        return userRepository.findByFirstnameContainingIgnoreCase(firstname)
    }

    fun getUserByLastname(lastname: String): List<User> {
        return userRepository.findByLastnameContainingIgnoreCase(lastname)
    }

    fun getUserByEmail(email: String): List<User> {
        return userRepository.findByEmailContainingIgnoreCase(email)
    }

    fun getUserByFirstnameAndLastnameAndEmail(firstname: String, lastname: String, email: String): User? {
        return userRepository.findByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCaseAndEmailContainingIgnoreCase(
            firstname,
            lastname,
            email
        )
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
            payment?.id = user.payment?.id ?: payment?.id
        }
        return userRepository.save(userToUpdate)
    }

    fun deleteUser(id: Int) {
        userRepository.deleteById(id)
    }
}