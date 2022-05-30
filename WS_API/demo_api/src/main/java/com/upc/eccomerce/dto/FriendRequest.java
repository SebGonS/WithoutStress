package com.upc.eccomerce.dto;

import lombok.Data;

@Data
public class FriendRequest {
    private String username;
    private Integer hashcode;
    private String friend_username;
}
