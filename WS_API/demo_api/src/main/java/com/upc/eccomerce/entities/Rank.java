package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rangos")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "nombre", nullable = false,length = 15)
    private String name;
    @Column(name= "xpMax", nullable = false)
    private Integer max_xp;
}
