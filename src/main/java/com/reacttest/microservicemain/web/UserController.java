/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.web;

import com.reacttest.microservicemain.domain.User;
import com.reacttest.microservicemain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kevin
 */

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/saveUserDetails")
    public ResponseEntity<?> saveUserDetails(@RequestBody User user) {
        System.out.println("In saveUserDetails");
        user = userService.saveUserDetails(user);
        
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
    
    @GetMapping("/fetchAllUserDetails")
    public Iterable<User> fetchAllUserDetails() {
        System.out.println("In fetchAllUserDetails");
        
        return userService.fetchAllUserDetails();
    }
    
    @PostMapping("/fetchUserDetailsForId")
    public ResponseEntity<?> fetchUserDetailsForId(@RequestBody Integer userId) {
        System.out.println("In fetchUserDetailsForId"+userId);
        
        return new ResponseEntity<User> (userService.fetchUserDetailsById(userId), HttpStatus.FOUND);
    }
    
    @PostMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody Integer userId) {
        System.out.println("In fetchUserDetailsForId"+userId);
        
        return new ResponseEntity<String> (userService.deleteUser(userId), HttpStatus.FOUND);
    }
    
}
