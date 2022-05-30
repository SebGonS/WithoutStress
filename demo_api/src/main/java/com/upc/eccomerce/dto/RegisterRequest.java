package com.upc.eccomerce.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RegisterRequest {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String surname;
    @NotBlank
    @NotNull
    private String username;
    @NotBlank
    @NotNull
    private Integer hash;
}
