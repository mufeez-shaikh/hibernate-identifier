package com.mufizco.hibernateapp.rest;

import com.mufizco.hibernateapp.entities.manytomany.Listing;
import com.mufizco.hibernateapp.entities.manytomany.Users;
import com.mufizco.hibernateapp.repositories.manytomany.ListingRepository;
import com.mufizco.hibernateapp.repositories.manytomany.UsersRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/manytomany")
public class ManyToManyController {

    @Autowired
    private UsersRepostiory usersRepostiory;

    @Autowired
    private ListingRepository listingRepository;

    @PostMapping(path = "/usersWithListing")
    public ResponseEntity<Users> saveUsersWithListings(@RequestBody Users users){
        int randomInt = Utility.getRandomInt();
        String userName = users.getUserName()+ randomInt;
        Users userToSave = users.toBuilder().userName(userName).build();
        userToSave.getListings().forEach( l -> l.setUsers(new HashSet<>(Arrays.asList(userToSave))));


        Users userSaved = usersRepostiory.save(userToSave);
        return ResponseEntity.ok(userSaved);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Users> usersById(@PathVariable Long userId){
        Optional<Users> usersbyId = usersRepostiory.findById(userId);
        if(usersbyId.isPresent()){
            return ResponseEntity.ok(usersbyId.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping(path = "/listingForUserName")
//    public ResponseEntity<Listing> saveListingWithUserName(@RequestBody Listing listing){
//        int randomInt = Utility.getRandomInt();
//        String itemName = listing.getItemName()+ randomInt;
//        Set<Users> users = listing.getUsers();
//        users.forEach(u -> u.setUserName( u.getUserName() + randomInt));
//
//        List<Users> usersList = usersRepostiory.saveAll(users);
//        Listing listingToSave = Listing.builder().itemName(itemName).users(new HashSet<>(usersList)).build();
//
//        Listing listingSaved = listingRepository.save(listingToSave);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }


}
