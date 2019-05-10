/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.web;

import com.reacttest.microservicemain.domain.User;
import com.reacttest.microservicemain.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kevin
 */
@RequestMapping("/login")
@RestController
@CrossOrigin
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @RequestMapping("/adminLogin")
    public ResponseEntity<?> adminLogin(@RequestBody User user) {
        try {
            System.out.println("In admin login functionality");
            System.out.println("user details "+user.toString());
            
            User validatedUser = loginService.checkExistingUserName(user.getUserName());
            
            if(validatedUser != null) {
                
                return new ResponseEntity<User>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
            }
            
        } catch(Exception e) {
            System.out.println("Exception in adminLogin :: "+e.getMessage());
            return new ResponseEntity<User>(user, HttpStatus.EXPECTATION_FAILED);
        }
        
    }
}
