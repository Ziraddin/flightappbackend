package com.example.flightapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@SpringBootApplication
class FlightappApplication

fun main(args: Array<String>) {
    runApplication<FlightappApplication>(*args)
}


@Service
class UserService(val db: JdbcTemplate) {
    fun getAllUsers(): List<User> {
        return db.query("SELECT * FROM users") { rs, _ ->
            User(rs.getString("id"), rs.getString("name"))
        }
    }

    fun getUserById(id: String): List<User> {
        return db.query("SELECT * FROM users WHERE id = ?", arrayOf(id)) { rs, _ ->
            User(rs.getString("id"), rs.getString("name"))
        }
    }

    fun addUser(user: User) {
        val id: String = user.id ?: UUID.randomUUID().toString()
        db.update("INSERT INTO users (id, name) VALUES (?, ?)", id, user.name)
    }

}

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {
    @GetMapping("/getAllUsers")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @GetMapping("/getUser/{id}")
    fun getUser(@PathVariable id: String): List<User> {
        return userService.getUserById(id)
    }

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User) {
        userService.addUser(user)
    }
}

data class User(var id: String?, val name: String)
