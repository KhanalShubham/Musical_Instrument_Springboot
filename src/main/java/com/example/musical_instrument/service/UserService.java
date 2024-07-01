package com.example.musical_instrument.service;

import com.example.musical_instrument.entity.User;
import com.example.musical_instrument.pojo.UserPojo;

import java.util.List;

public interface UserService {
    User createUser(UserPojo userPojo);
    UserPojo updateUser(Integer id, UserPojo userPojo);
    UserPojo deleteUser(Integer id);
    User getUserById(Integer id);
    List<User> getAllUsers();
}
