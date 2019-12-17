package com.mufizco.hibernateapp.repositories;

import com.mufizco.hibernateapp.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>  {
}
