package com.upc.eccomerce.services;


import com.upc.eccomerce.dto.RegisterRequest;
import com.upc.eccomerce.dto.UserLoginRequest;
import com.upc.eccomerce.entities.User;
import com.upc.eccomerce.exception.IncorrectOrderRequestException;
import com.upc.eccomerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public  UserService(UserRepository repo){this.userRepository = repo;}

    @Transactional(readOnly = true)
    public User getUserById(Integer userId){
        return userRepository.findUserById(userId);
    }

    private User initUser(RegisterRequest registerRequest)
    {
        User userObj = new User();
        if(userRepository.findByUsername(registerRequest.getUsername()) != null)
        {
            throw new IncorrectOrderRequestException("El username ya se encuentra registrado");
        }
        userObj.setName(registerRequest.getName());
        userObj.setSurname(registerRequest.getSurname());
        userObj.setUsername(registerRequest.getUsername());
        //userObj.setPremium(Boolean.FALSE);
        userObj.setRank_id(1);
        userObj.setXp(0);
        userObj.setHashcode(registerRequest.getHash().hashCode());

        return userObj;
    }

    @Transactional
    public User registerUser(RegisterRequest registerRequest)
    {
        User userNew = initUser(registerRequest);
        return userRepository.save(userNew);
    }
    @Transactional
    public User login(UserLoginRequest loginRequest)
    {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if(user.getHashcode() == null)
        {
            throw new IncorrectOrderRequestException("El usuario no registrado");
        }
        if(user.getHashcode() != loginRequest.getHashcode().hashCode())
        {
            throw new IncorrectOrderRequestException("El contraseña incorrecta");
        }
        return user;
    }
}
