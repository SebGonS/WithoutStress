package com.upc.eccomerce.entities;

import lombok.Data;
import com.upc.eccomerce.util.RequestType;
import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "solicitudes")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name= "usuariosR_Id", nullable = false)
    private Integer recipient_id;
    @Column(name= "usuariosE_Id", nullable = false)
    private Integer sender_id;
    @Column(name= "tipo", nullable = false, length = 10)
    @Enumerated(value = EnumType.STRING)
    private RequestType type;
    @Column(name= "fecha", nullable = false)
    private Instant fecha;
}
