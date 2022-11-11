package com.ashraf.blog.service.Impl;

import com.ashraf.blog.models.User;
import com.ashraf.blog.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.*;
//import org.junit.runner.RunWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@Runwith
class UserServiceImplTest {

    @InjectMocks
    @Spy
    UserServiceImpl userService;

    @Autowired
    UserRepo userRepo;

    @Test
    void registerNewUser() {
    }

    @Test
    void createUSer() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserById() {
        User user=getDummyUser();

        Mockito.when(this.userRepo.findById(Mockito.any())).thenReturn(Optional.of(user));

//        Assert
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void deleteUser() {
    }

    // Dummy Methods

    private User getDummyUser() {
        User user=new User();
        user.setId(420);
        user.setName("Dummy");
        user.setAbout("I am Dummy for testing purposes");

        return user;
    }

}