package com.example.usersapi.controller;

import com.example.usersapi.models.User;
import com.example.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Iterable<User> getAll() {
        return userService.listUsers();
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/create")
    public HttpStatus createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PatchMapping("/update/{id}")
    public HttpStatus updateUser(@PathVariable long id, @RequestBody User userRequest) {
        userService.updateUser(id, userRequest);
        return HttpStatus.OK;
    }

    @GetMapping("/search/{userId}")
    public User getUserByUserId(@PathVariable Long userId){
        return userService.getUserByUserId(userId);
    }
}
