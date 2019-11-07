package com.example.usersapi.service;


import com.example.usersapi.models.User;
import org.springframework.http.HttpStatus;

public interface UserService{
    public Iterable<User> listUsers();
    public HttpStatus createUser(User user);
    public HttpStatus deleteUser(Long userId);
    public User getUserByUserId(Long userId);
    public HttpStatus updateUser(long userId, User user);

}
