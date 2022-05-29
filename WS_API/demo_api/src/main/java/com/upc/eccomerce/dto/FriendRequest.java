package com.upc.eccomerce.dto;

import lombok.Data;

@Data
public class FriendRequest {
    private UserLoginRequest user;
    private FriendsDetail friend;
}
