package com.mufizco.hibernateapp.repositories.manytomany;

import com.mufizco.hibernateapp.entities.manytomany.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepostiory extends JpaRepository<Users, Long> {
}
