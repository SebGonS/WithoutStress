package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetTime;

@Data
@Entity
@Table(name = "subscripciones")
public class Subscriptions {
    @Id
    @Column(name = "usuarios_id")
    private  Integer id;
    @Column(name= "inicio", nullable = false,length = 25)
    private Instant start;
    @Column(name= "fin", nullable = false,length = 25)
    private LocalDate end;
}
