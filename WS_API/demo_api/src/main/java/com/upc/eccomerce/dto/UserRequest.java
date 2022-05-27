package com.upc.eccomerce.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private FriendsDetail friend;
}
