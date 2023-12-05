package com.example.flightapp.controllers

import com.example.flightapp.dtos.User
import com.example.flightapp.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {
    @GetMapping("/getAllUsers")
    fun getAllUsers() = userService.getAllUsers()

    @GetMapping("/getUser")
    fun getUserById(@RequestParam firstname: String, @RequestParam lastname: String, @RequestParam email: String) =
        userService.getUserByFirstnameAndLastnameAndEmail(
            firstname,
            lastname,
            email
        )

    @GetMapping("/getUserByFirstname")
    fun getUserByFirstname(@RequestParam firstname: String) = userService.getUserByFirstname(firstname)

    @GetMapping("/getUserByLastname")
    fun getUserByLastname(@RequestParam lastname: String) = userService.getUserByLastname(lastname)

    @GetMapping("/getUserByEmail")
    fun getUserByEmail(@RequestParam email: String) = userService.getUserByEmail(email)

    @PostMapping("/addUser")
    fun createUser(@RequestBody user: User) = userService.createUser(user)

    @PutMapping("/updateUser")
    fun updateUser(@RequestParam id: Int, @RequestBody user: User) = userService.updateUser(id, user)

    @DeleteMapping("/deleteUser")
    fun deleteUser(@RequestParam id: Int) = userService.deleteUser(id)
}