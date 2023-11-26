package com.example.flightapp.repositories

import com.example.flightapp.dtos.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int>