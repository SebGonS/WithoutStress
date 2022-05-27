package com.upc.eccomerce.repository;

import com.upc.eccomerce.entities.Friend;
import com.upc.eccomerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
    List<Integer> findAlluser2_idByuser1_id(Integer user1_id);
}
