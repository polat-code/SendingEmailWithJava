package com.example.emaildemo.service;

import com.example.emaildemo.exceptions.InvalidUserFields;
import com.example.emaildemo.model.User;
import com.example.emaildemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) throws InvalidUserFields {
        if(user.getUserName() == null || user.getUserSurname() == null
        || user.getBirthday() == null || user.getEmail() == null) {
            throw new InvalidUserFields("There are some empty fields");
        }
        userRepository.save(user);


    }
}
