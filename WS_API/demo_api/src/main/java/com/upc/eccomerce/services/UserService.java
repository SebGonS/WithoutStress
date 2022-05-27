package com.upc.eccomerce.services;


import com.upc.eccomerce.dto.FriendsDetail;
import com.upc.eccomerce.dto.RegisterRequest;
import com.upc.eccomerce.dto.UserLoginRequest;
import com.upc.eccomerce.dto.UserRequest;
import com.upc.eccomerce.entities.Friend;
import com.upc.eccomerce.entities.User;
import com.upc.eccomerce.exception.IncorrectOrderRequestException;
import com.upc.eccomerce.repository.FriendRepository;
import com.upc.eccomerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private FriendRepository friendRepository;

    public  UserService(UserRepository repo, FriendRepository frepo){
        this.userRepository = repo;
        this.friendRepository = frepo;
    }

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
    public User login(UserLoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user.getHashcode() == null) {
            throw new IncorrectOrderRequestException("El usuario no registrado");
        }
        if (user.getHashcode() != loginRequest.getHashcode().hashCode()) {
            throw new IncorrectOrderRequestException("El contraseña incorrecta");
        }
        return user;
    }
    @Transactional
    public Friend AgregarAmigo(UserRequest userRequest){
        Friend friend = new Friend();
        User user1 = userRepository.findByUsername(userRequest.getUsername());
        User user2 = userRepository.findByUsername(userRequest.getFriend().getUsername());
        friend.setUser1_id(user1.getId());
        friend.setUser2_id(user2.getId());
        return friendRepository.save(friend);
    }

    @Transactional
    public List<Integer> getFriends(Integer userId){
        return friendRepository.findAlluser2_idByuser1_id(userId);
    }
}
