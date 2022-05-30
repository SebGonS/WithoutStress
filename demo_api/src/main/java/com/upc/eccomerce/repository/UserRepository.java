package com.upc.eccomerce.repository;

import com.upc.eccomerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SElECT o FROM User o WHERE o.username = ?1")
    User findByUsername(String username);

    User findUserById(Integer id);


}
