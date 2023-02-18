package com.example.Crud.operation.and.validation.service;

import com.example.Crud.operation.and.validation.model.User;
import com.example.Crud.operation.and.validation.reposatory.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
 @Autowired
     UserRepository userRepository;
 public List<User>findAll(){
     return userRepository.findAll();
 }
 public User findById(int userId) throws Exception {
     User user=userRepository.findById(userId)
             .orElseThrow(() ->new Exception("no details found for this user id"));
             return user;

 }

    public User saveUser(User user) {

     return userRepository.save(user);
    }

    public void  updateUser(int userId, User newUser) {
     User user=userRepository.findById(userId).get();
     user.setUserId(newUser.getUserId());
     user.setUsername(newUser.getUsername());
     user.setEmail(newUser.getEmail());

    }


}
