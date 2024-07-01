package com.example.musical_instrument.controller;


import com.example.musical_instrument.entity.User;
import com.example.musical_instrument.pojo.UserPojo;
import com.example.musical_instrument.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserPojo userPojo) {
        User createdUser = userService.createUser(userPojo);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPojo> updateUser(@PathVariable Integer id, @RequestBody UserPojo userPojo) {
        UserPojo updatedUser = userService.updateUser(id, userPojo);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user= userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users= userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
