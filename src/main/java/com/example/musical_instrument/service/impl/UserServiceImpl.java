package com.example.musical_instrument.service.impl;


import com.example.musical_instrument.entity.User;
import com.example.musical_instrument.pojo.UserPojo;
import com.example.musical_instrument.repository.UserRepository;
import com.example.musical_instrument.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(UserPojo userPojo) {
        User user = new User();
        user.setUser_name(userPojo.getUser_name());
        user.setUser_password(userPojo.getUser_password());
        user.setUser_email(userPojo.getUser_email());
        user.setUser_contact(userPojo.getUser_contact());
        user.setUser_role(userPojo.getUser_role());
        return userRepository.save(user);
    }

    @Override
    public UserPojo updateUser(Integer id, UserPojo userPojo) {
        Optional<User> userOptional=userRepository.findById(id);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            user.setUser_name(userPojo.getUser_name());
            user.setUser_password(userPojo.getUser_password());
            user.setUser_email(userPojo.getUser_email());
            user.setUser_contact(userPojo.getUser_contact());
            user.setUser_role(userPojo.getUser_role());
        }
        return null;
    }

    @Override
    public UserPojo deleteUser(Integer id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
