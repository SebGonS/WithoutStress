package com.upc.eccomerce.repository;

import com.upc.eccomerce.entities.Reto;
import com.upc.eccomerce.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetosRepository extends JpaRepository<Reto, Integer> {
}
