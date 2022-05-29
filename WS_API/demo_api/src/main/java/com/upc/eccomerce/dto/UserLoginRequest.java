package com.upc.eccomerce.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserLoginRequest {
    @NotBlank
    @NotNull
    private String username;
    @NotNull
    @NotBlank
    private Integer hashcode;
}
