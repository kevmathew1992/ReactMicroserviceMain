/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.service;

import com.reacttest.microservicemain.domain.User;
import com.reacttest.microservicemain.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin
 */
@Service
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;
    
    public User checkExistingUserName(String userName) {
        User user = loginRepository.findByUserName(userName);
        if(user != null) {
            System.out.println("user Name :: "+user.getUserName());
            System.out.println("password :: "+user.getPassword());
        } else {
            System.out.println("In checkExistingUserName else");
        }
        return user;
    }
    
}
