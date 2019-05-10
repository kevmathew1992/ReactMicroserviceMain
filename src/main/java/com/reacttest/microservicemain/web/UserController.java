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
import org.springframework.web.bind.annotation.RequestParam;
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
        System.out.println("In saveUserDetails " + user);
        user = userService.saveUserDetails(user);
        String message = "";
        
        if(user != null) {
            message = "User created successfully";
        } else {
            message= "Error creating user";
        }
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
    
    @PostMapping("/updateUserDetails")
    public ResponseEntity<?> updateUserDetails(@RequestBody User user) {
        System.out.println("In updateUserDetails");
        user = userService.saveUserDetails(user);
        String message = "";
        
        if(user != null) {
            message = "User updated successfully";
        } else {
            message= "Error updating user";
        }
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
    
    @GetMapping("/fetchAllUserDetails")
    public ResponseEntity<?> fetchAllUserDetails() {
        System.out.println("In fetchAllUserDetails");
        
        return new ResponseEntity<Iterable<User>> (userService.fetchAllUserDetails(), HttpStatus.OK);
    }
    
    @PostMapping("/fetchUserDetailsForId")
    public ResponseEntity<?> fetchUserDetailsForId(@RequestBody Integer userId) {
        System.out.println("In fetchUserDetailsForId"+userId);
        
        return new ResponseEntity<User> (userService.fetchUserDetailsById(userId), HttpStatus.OK);
    }
    
    @PostMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        System.out.println("In fetchUserDetailsForId"+user.getUserId());
        
        return new ResponseEntity<String> (userService.deleteUser(user.getUserId()), HttpStatus.OK);
    }
    
}
