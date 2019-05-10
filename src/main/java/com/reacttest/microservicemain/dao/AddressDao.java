/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reacttest.microservicemain.dao;

import com.reacttest.microservicemain.domain.Address;

/**
 *
 * @author Kevin
 */
public interface AddressDao {
    
    public Iterable<Address> fetchAllStateList();
}
