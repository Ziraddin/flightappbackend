package com.example.flightapp.repositories

import com.example.flightapp.dtos.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int> {
    fun findByFirstnameContainingIgnoreCase(firstname: String): List<User>

    fun findByLastnameContainingIgnoreCase(lastname: String): List<User>

    fun findByEmailContainingIgnoreCase(email: String): List<User>

    fun findByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCaseAndEmailContainingIgnoreCase(
        firstname: String,
        lastname: String,
        email: String
    ): User?
}