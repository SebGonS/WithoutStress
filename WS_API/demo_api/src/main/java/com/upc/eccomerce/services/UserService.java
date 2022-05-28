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
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
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
        Friend friend = new Friend();
        User user1 = userRepository.findByUsername(friendRequest.getUsername());
                //.orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
        User user2 = userRepository.findByUsername(friendRequest.getFriend().getUsername());
        friend.setUser1Id(user1.getId());
        friend.setUser2Id(user2.getId());
        return friendRepository.save(friend);
    }

    @Transactional
    public List<User> getFriends(String username){
        return getUser(friendRepository.findAllUser2IdByUser1Id(userRepository.findByUsername(username).getId()));
    }
    public List<User> getUser(List<Integer> friends){
        List userList = new ArrayList();
        for (Integer friend : friends) {
            userList.add(userRepository.findUserById(friend));
        }
        return userList;
    }
}
