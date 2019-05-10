/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.service;

import com.reacttest.microservicemain.dao.AddressDao;
import com.reacttest.microservicemain.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin
 */
@Service
public class AddressServiceImpl implements AddressService{
    
    @Autowired
    private AddressDao addressDao;
    
    public Iterable<Address> fetchAllStateList() {
        return addressDao.fetchAllStateList();
    }
    
}
