package com.example.usersapi.service;

import com.example.usersapi.models.User;
import com.example.usersapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public HttpStatus createUser(User user) {
        userRepository.save(user);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateUser(long userId, User userInfo) {
        User user = userRepository.findById(userId).get();
        user.setUsername(userInfo.getUsername());
        user.setFirstname(userInfo.getFirstname());
        user.setLastname(userInfo.getLastname());
        userRepository.save(user);
        return HttpStatus.OK;
    }

    @Override
    public User getUserByUserId(Long userId){
        return userRepository.findById(userId).get();
    }


}
