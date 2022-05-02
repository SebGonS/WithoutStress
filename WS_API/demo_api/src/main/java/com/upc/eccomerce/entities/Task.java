package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "actividades")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name= "usuarios_Id", nullable = false)
    private Integer user_id;
    @Column(name= "titulo", nullable = false, length = 30)
    private String name;
    @Column(name= "descripcion", nullable = false, length = 100)
    private String summary;
}
