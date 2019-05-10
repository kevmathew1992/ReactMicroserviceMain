/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.repository;

import com.reacttest.microservicemain.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kevin
 */
public interface TestRepository extends JpaRepository<User, String> {
    
}
