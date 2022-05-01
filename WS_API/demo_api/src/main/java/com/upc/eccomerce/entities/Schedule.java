package com.upc.eccomerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetTime;

@Data
@Entity
@Table(name = "horarios")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "actividades_Id", nullable = false)
    private  Long task_id;
    @Column(name= "actividades_usuarios_Id", nullable = false)
    private long user_id;
    @Column(name= "fecha", nullable = false, length = 30)
    private LocalDate date;
    @Column(name= "inicio", nullable = false, length = 100)
    private OffsetTime start_time;
    @Column(name= "fin", nullable = false, length = 100)
    private OffsetTime end_time;
}
