package com.upc.eccomerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskRequest {
    @NotBlank
    @NotNull
    private Integer user_id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String summary;
}
