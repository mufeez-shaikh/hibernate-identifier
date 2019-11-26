package com.mufizco.hibernateapp.repositories;

import com.mufizco.hibernateapp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
