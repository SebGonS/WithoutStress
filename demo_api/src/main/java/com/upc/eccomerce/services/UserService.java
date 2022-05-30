package com.upc.eccomerce.services;


import com.upc.eccomerce.dto.RegisterRequest;
import com.upc.eccomerce.dto.UserLoginRequest;
import com.upc.eccomerce.dto.FriendRequest;
import com.upc.eccomerce.entities.Friend;
import com.upc.eccomerce.entities.User;
import com.upc.eccomerce.exception.IncorrectOrderRequestException;
import com.upc.eccomerce.exception.UserNotFoundException;
import com.upc.eccomerce.repository.FriendRepository;
import com.upc.eccomerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public Friend addFriend(FriendRequest friendRequest){
        User user = userRepository.findByUsername(friendRequest.getUsername());
        if (user.getHashcode() == null) {
            throw new IncorrectOrderRequestException("El usuario no registrado");
        }
        if (user.getHashcode() != friendRequest.getHashcode().hashCode()) {
            throw new IncorrectOrderRequestException("El contraseña incorrecta");
        }
        Friend friend = new Friend();
        Friend friend1  = new Friend();
                //.orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
        User user2 = userRepository.findByUsername(friendRequest.getFriend_username());
                //.orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
        friend.setUser1Id(user.getId());
        friend.setUser2Id(user2.getId());
        friend1.setUser1Id(user2.getId());
        friend1.setUser2Id(user.getId());
        friendRepository.save(friend);
        return friendRepository.save(friend1);
    }

    @Transactional
    public List<User> getFriends(String username){
        List<Integer> friends = friendRepository.findAllUser2IdByUser1Id(userRepository.findByUsername(username).getId());
        return getUser(friends);
    }
    private List<User> getUser(List<Integer> friends){
        List<User> userList = new ArrayList<>();
        for (Integer friend : friends) {
            userList.add(getUserById(friend));
        }
        return userList;
    }
}
