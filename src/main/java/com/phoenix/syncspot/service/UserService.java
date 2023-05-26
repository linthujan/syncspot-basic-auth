package com.phoenix.syncspot.service;

import com.phoenix.syncspot.entity.User;
import com.phoenix.syncspot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }
    public Optional<User> getUser(Long id){
        return userRepo.findById(id);
    }
    public Collection<User> getUsers(){
        List<User> users = userRepo.findAll();
        return users;
    }
}
