package com.mufizco.hibernateapp.rest;

import com.mufizco.hibernateapp.entities.Address;
import com.mufizco.hibernateapp.entities.Student;
import com.mufizco.hibernateapp.services.AddressService;
import com.mufizco.hibernateapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Address> post(@RequestBody Address address) {
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        String street = address.getStreet() + randomInt;
        String city = address.getCity() + randomInt;
        String unitNo = address.getUnitNo() + randomInt;
        int zip = address.getZip() + randomInt;
        String state = address.getState() + randomInt;
        Student student = studentService.getAll().stream()
                .filter(s -> s.getId().equals(address.getStudent().getId()))
                .findFirst().orElse(null);
        Address addressToSave = Address.builder()
                .city(city)
                .street(street)
                .city(city)
                .state(state)
                .zip(zip)
                .build();
        Address addressSaved = addressService.save(address);

        return ResponseEntity.ok(addressSaved);
    }
}
