package com.mufizco.hibernateapp;

import com.mufizco.hibernateapp.entities.Account;
import com.mufizco.hibernateapp.repositories.AccountRepository;
import com.mufizco.hibernateapp.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration( classes = {TestApplication.class})
@AutoConfigureTestDatabase
public class SpringIntegrationTest {

    @Autowired
    AccountRepository accountService;

    @Test
    public void testSave(){
        Account account = accountService.save(Account.builder().email("abc@.com").username("asdfadf").password("lkjk").build());
        List<Account> accounts = accountService.findAll();
        assertTrue(accounts.size() >0);
    }
}