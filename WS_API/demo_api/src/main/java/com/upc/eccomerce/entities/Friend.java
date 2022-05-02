package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "amigos")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name= "usuarios_Id", nullable = false)
    private Integer user1_id;
    @Column(name= "usuarios_2_Id", nullable = false)
    private Integer user2_id;
}
