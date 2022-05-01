package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "amigos")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "usuarios_Id", nullable = false)
    private long user1_id;
    @Column(name= "usuarios_2_Id", nullable = false)
    private long user2_id;
}
