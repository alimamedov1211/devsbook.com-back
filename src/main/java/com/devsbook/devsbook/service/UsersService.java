package com.devsbook.devsbook.service;


import com.devsbook.devsbook.entity.User;
import com.devsbook.devsbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
public class UsersService {

    UserRepository userRepository;

    @Value("${default.profile.picture}")
    String defaultProfilePic;


    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private String generateToken(User user) {
        String values = user.getEmail() + "*_*" + user.getName() + "*_*" + user.getSurname();
        String encodedString = Base64.getEncoder().encodeToString(values.getBytes());
        return encodedString;
    }

    public String checkEmail(String email) {
        User user = userRepository.findByEmail(email);
        System.out.println("Check email: " + user);
        if (user == null) {
            return "0";
        } else
            return user.getToken();
    }

    public String checkUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        System.out.println("Check user: " + user);
        if (user == null) {
            return "0";
        } else
            return user.getToken();
    }

    public String createUser(User user) {
        String checkedUser = checkEmail(user.getEmail());
        System.out.println("CreateUser: " + checkedUser);
        if (checkedUser.equals("0")) {
            user.setCreateTime(LocalDateTime.now());
            user.setToken(generateToken(user));
            user.setProfilePhoto(defaultProfilePic);
            User user1 = userRepository.save(user);
            return user1.getName();
        } else
            return "0";
    }

    public User getUserByToken(String token){
        User user = userRepository.findByToken(token);
        return user;
    }

    public void changeProfilePic(String base64, String token){
        User user = userRepository.findByToken(token);
        user.setProfilePhoto(base64);
        userRepository.save(user);
    }



    public void deleteAll() {
        userRepository.deleteAll();
    }


}
