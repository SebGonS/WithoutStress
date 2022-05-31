package com.upc.eccomerce.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginRequest {
    @NotBlank
    @NotNull
    private String username;
    @NotNull
    @NotBlank
    private String hashcode;
}
