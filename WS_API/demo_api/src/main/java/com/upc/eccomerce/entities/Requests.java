package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "solicitudes")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "usuariosR_Id", nullable = false)
    private long recipient_id;
    @Column(name= "usuariosE_Id", nullable = false)
    private long sender_id;
    @Column(name= "tipo", nullable = false, length = 10)
    @Enumerated(value = EnumType.STRING)
    private String Type;
    @Column(name= "fecha", nullable = false)
    private Instant Fecha;
}
