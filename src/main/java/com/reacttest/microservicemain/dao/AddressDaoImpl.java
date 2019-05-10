/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.dao;

import com.reacttest.microservicemain.domain.Address;
import com.reacttest.microservicemain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kevin
 */
@Repository
public class AddressDaoImpl implements AddressDao {
    
    @Autowired
    private AddressRepository addressRepository;
    
    public Iterable<Address> fetchAllStateList() {
        return addressRepository.findAll();
    }
}
