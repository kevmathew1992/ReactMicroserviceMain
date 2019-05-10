/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.service;

import com.reacttest.microservicemain.domain.User;
import com.reacttest.microservicemain.repository.TestRepository;
import com.reacttest.microservicemain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TestRepository testRepository;
    
    public User saveUserDetails(User user) {
        
        return userRepository.save(user);
    }
    
    public Iterable<User> fetchAllUserDetails() {
        Iterable<User> userList = userRepository.findAll();
        System.out.println(""+userList);
        System.out.println(""+userList.toString());
        
        return userRepository.findAll();
    }
    
    public User fetchUserDetailsById(Integer userId) {
        return userRepository.getByUserId(userId);
    }
    
    public String deleteUser(Integer userId) {
        try {
            userRepository.deleteById(userId);
            return "User deleted successfully.";
        } catch(Exception e) {
            return "Error in deleting user.";
        }
    }
    
}
