package com.mufizco.hibernateapp.repositories.manytomany;

import com.mufizco.hibernateapp.entities.manytomany.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
