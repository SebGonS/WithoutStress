package com.upc.eccomerce.util;

import com.upc.eccomerce.dto.FriendResponse;
import com.upc.eccomerce.dto.LoginResponse;
import com.upc.eccomerce.dto.RegisterRequest;
import com.upc.eccomerce.dto.UserResponse;
import com.upc.eccomerce.entities.Friend;
import com.upc.eccomerce.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersDtoConverter {
    private ModelMapper modelMapper;

    public UsersDtoConverter(ModelMapper modelMapper){ this.modelMapper = modelMapper;}

    public LoginResponse convertEntityToDto(User user)
    {
        return modelMapper.map(user, LoginResponse.class);
    }

    public UserResponse convertEntityToDtoR(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public List<UserResponse> convertEntityToDto(List<User> users) {
        return users.stream()
                .map(user -> convertEntityToDtoR(user))
                .collect(Collectors.toList());
    }

    public FriendResponse convertEntityToDto(Friend friend) {
        return modelMapper.map(friend, FriendResponse.class);
    }
}
