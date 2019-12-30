package com.mufizco.hibernateapp.rest;

import com.mufizco.hibernateapp.entities.manytomany.Listing;
import com.mufizco.hibernateapp.entities.manytomany.Users;
import com.mufizco.hibernateapp.repositories.manytomany.ListingRepository;
import com.mufizco.hibernateapp.repositories.manytomany.UsersRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/manytomany")
public class ManyToManyController {

    @Autowired
    private UsersRepostiory usersRepostiory;

    @Autowired
    private ListingRepository listingRepository;

    @PostMapping(path = "/users")
    public ResponseEntity<Users> saveUsers(@RequestBody Users users){
        int randomInt = Utility.getRandomInt();
        String userName = users.getUserName()+ randomInt;
        Users userToSave = Users.builder().userName(userName).build();
        Users userSaved = usersRepostiory.save(userToSave);
        return ResponseEntity.ok(userSaved);
    }

    @PostMapping(path = "/listing")
    public ResponseEntity<Listing> saveListing(@RequestBody Listing listing){
        int randomInt = Utility.getRandomInt();
        String itemName = listing.getItemName()+ randomInt;
        Set<Users> users = listing.getUsers();
        users.forEach(u -> u.setUserName( u.getUserName() + randomInt));

        List<Users> usersList = usersRepostiory.saveAll(users);
        Listing listingToSave = Listing.builder().itemName(itemName).users(new HashSet<>(usersList)).build();

        Listing listingSaved = listingRepository.save(listingToSave);
        return ResponseEntity.ok(listingSaved);
    }


}
