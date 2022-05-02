package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="retos")
public class Reto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name= "usuarios_Id", nullable = false)
    private Integer recipient_id;
    @Column(name= "usuarios_2_Id", nullable = false)
    private Integer sender_id;
    @Column(name= "actividades_id", nullable = false)
    private Integer activity_id;
    @Column(name= "actividades_usuarios_id", nullable = false)
    private Integer activity_owner_id;
}
