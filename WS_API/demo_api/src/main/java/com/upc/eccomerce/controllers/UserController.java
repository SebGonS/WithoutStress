package com.upc.eccomerce.controllers;

import com.upc.eccomerce.dto.LoginResponse;
import com.upc.eccomerce.dto.RegisterRequest;
import com.upc.eccomerce.dto.UserLoginRequest;
import com.upc.eccomerce.dto.UserResponse;
import com.upc.eccomerce.entities.User;
import com.upc.eccomerce.services.UserService;
import com.upc.eccomerce.util.UsersDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private UsersDtoConverter converter;

    public UserController(UserService userService, UsersDtoConverter usersDtoConverter)
    {
        this.userService = userService;
        this.converter = usersDtoConverter;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> registerUser(@RequestBody RegisterRequest request){
        User user = userService.registerUser(request);
        return new ResponseEntity<>(converter.convertEntityToDto(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody UserLoginRequest request){
        User user = userService.login(request);
        return new ResponseEntity<>(converter.convertEntityToDto(user), HttpStatus.ACCEPTED);
    }
}
