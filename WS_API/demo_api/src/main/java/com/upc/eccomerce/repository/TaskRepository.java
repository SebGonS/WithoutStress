package com.upc.eccomerce.repository;

import com.upc.eccomerce.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findTaskById(Integer id);

    List<Task> findByNameContaining(String name);
}