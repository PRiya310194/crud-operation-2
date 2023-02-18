package com.example.Crud.operation.and.validation.controller;

import com.example.Crud.operation.and.validation.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
@Autowired
    private UserService userService
    @GetMapping("/user")
    public List<User>getAllUser(){
      return userService.findAll();
    }
   @GetMapping("/user/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int userId) throws Exception {
    return ResponseEntity.ok(userService.findById(userId));
   }

   @PostMapping("/save-user")
    public User saveUser(@RequestBody User user){

    return userService.saveUser(user);
   }
   @PutMapping("/update-user/id/{id}")
    public void updateUser(@PathVariable int userId, @RequestBody User user)  {
   userService.updateUser(userId,user);
   }

}
