package com.upc.eccomerce.repository;

import com.upc.eccomerce.entities.Friend;
import com.upc.eccomerce.entities.User;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
    List<Integer> findAllUser2IdByUser1Id(Integer user1Id);
}
