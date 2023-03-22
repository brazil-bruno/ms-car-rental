package com.project.msuser.services;

import com.project.msuser.entities.User;
import com.project.msuser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }
}
