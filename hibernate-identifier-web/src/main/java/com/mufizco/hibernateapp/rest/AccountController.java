package com.mufizco.hibernateapp.rest;

import com.mufizco.hibernateapp.entities.Account;
import com.mufizco.hibernateapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> get(){

        List<Account> accounts = accountService.get();
        if(accounts != null || !accounts.isEmpty()){
            return ResponseEntity.ok(accounts);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Account> post(@RequestBody Account account){
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        String email = account.getEmail()+randomInt;
        String username = account.getUsername()+randomInt;
        Account newAccount = account.toBuilder()
                .createdOn(new Date()).lastLogin(new Date())
                .email(email)
                .username(username)
                .build();

        Account accountSaved = accountService.save(newAccount);
        return ResponseEntity.ok(accountSaved);
    }
}
