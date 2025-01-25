package com.example.TaskManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.example.TaskManagementSystem.model.User;
import com.example.TaskManagementSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User addUser(User user)
    {
        return userRepository.save(user);
    }

    public void deleteUser(Long user_id)
    {
        userRepository.deleteById(user_id);
    }

    public User getUserById(Long user_id) {
        return userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
