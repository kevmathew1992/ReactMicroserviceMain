/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.web;

import com.reacttest.microservicemain.domain.Address;
import com.reacttest.microservicemain.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kevin
 */
@RestController
@CrossOrigin
@RequestMapping("/location")
public class AddressController {
    
    @Autowired
    private AddressService addressService;
    
    @GetMapping("/fetchStateList")
    public ResponseEntity<?> fetchStateList() {
        return new ResponseEntity<Iterable<Address>> (addressService.fetchAllStateList(), HttpStatus.OK);
    }
    
}
