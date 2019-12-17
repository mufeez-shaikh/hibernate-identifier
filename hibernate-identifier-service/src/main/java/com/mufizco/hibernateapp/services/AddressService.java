package com.mufizco.hibernateapp.services;

import com.mufizco.hibernateapp.entities.Address;
import com.mufizco.hibernateapp.entities.Student;
import com.mufizco.hibernateapp.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public List<Address> getAll(){
        return addressRepository.findAll();
    }
}
