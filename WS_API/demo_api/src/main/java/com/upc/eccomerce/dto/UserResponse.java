package com.upc.eccomerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String username;
    private List<FriendListResponse> friends;
}
