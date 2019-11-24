package com.company.jpaidentifier.repository;

import com.company.jpaidentifier.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
