package com.mufizco.hibernateapp.services;

import com.mufizco.hibernateapp.entities.Account;
import com.mufizco.hibernateapp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public Account save (Account account){
        return repository.save(account);
    }

    public List<Account> get(){
         return repository.findAll();
    }
}
