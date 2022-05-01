package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="retos")
public class Reto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "usuarios_Id", nullable = false)
    private long recipient_id;
    @Column(name= "usuarios_2_Id", nullable = false)
    private long sender_id;
    @Column(name= "actividades_id", nullable = false)
    private long activity_id;
    @Column(name= "actividades_usuario_id", nullable = false)
    private long activity_owner_id;
}
