package com.upc.eccomerce.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String name;
    private String surname;
    private String rank;
    private String xp;
    private boolean premium;
}
