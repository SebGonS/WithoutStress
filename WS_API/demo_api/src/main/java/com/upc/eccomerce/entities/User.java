package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;


@Data
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name= "nombre", nullable = false,length = 25)
    private String name;
    @Column(name= "apellido", nullable = false,length = 25)
    private String surname;
    @Column(name= "usuario", nullable = false,length = 15)
    private String username;
    @Column(name= "hash", nullable = false)
    private Integer hashcode;
    @Column(name= "xp", nullable = false)
    private Integer xp;
    @Column(name= "rangos_id", nullable = false)
    private Integer rank_id;
    @Column(name= "premium", nullable = false)
    private Boolean premium;
}
