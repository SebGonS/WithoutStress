package com.upc.eccomerce.util;

import com.upc.eccomerce.dto.LoginResponse;
import com.upc.eccomerce.dto.RegisterRequest;
import com.upc.eccomerce.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsersDtoConverter {
    private ModelMapper modelMapper;

    public UsersDtoConverter(ModelMapper modelMapper){ this.modelMapper = modelMapper;}

    public LoginResponse convertEntityToDto(User user)
    {
        return modelMapper.map(user, LoginResponse.class);
    }

}
