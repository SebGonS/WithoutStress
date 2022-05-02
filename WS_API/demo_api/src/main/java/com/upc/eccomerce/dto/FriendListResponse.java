package com.upc.eccomerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class FriendListResponse {
    private Integer total;
    List<FriendsDetail> friends;
}
