package com.jwtdemo.service;

import com.jwtdemo.model.User;
import com.jwtdemo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                ()->{throw new UsernameNotFoundException("User not found with username: " + username);});
        return user;
    }

    public User createUser(UserModel userModel) {
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return user;
    }
}
