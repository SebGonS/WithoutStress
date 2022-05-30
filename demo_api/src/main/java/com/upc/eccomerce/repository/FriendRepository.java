package com.upc.eccomerce.repository;

import com.upc.eccomerce.entities.Friend;
import com.upc.eccomerce.entities.User;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
    //@Query(value = "SELECT  * FROM orders o WHERE o.order_id = ?1", nativeQuery = true)//sql
    @Query(value="SELECT a.usuarios_2_Id from amigos a where a.usuarios_Id = ?1", nativeQuery = true)
    List<Integer> findAllUser2IdByUser1Id(Integer user1Id);
}
