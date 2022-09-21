package com.devsbook.devsbook.controller;


import com.devsbook.devsbook.DTO.Response.UserData;
import com.devsbook.devsbook.entity.Friend;
import com.devsbook.devsbook.entity.User;
import com.devsbook.devsbook.service.FriendsService;
import com.devsbook.devsbook.service.PostsService;
import com.devsbook.devsbook.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DevsBookController {

    UsersService usersService;
    PostsService postsService;
    FriendsService friendsService;

    @Autowired
    public DevsBookController(UsersService usersService, PostsService postsService, FriendsService friendsService) {
        this.usersService = usersService;
        this.postsService = postsService;
        this.friendsService = friendsService;
    }


    @CrossOrigin
    @GetMapping("/checkUser")
    public String checkUser(@RequestParam String mail, @RequestParam String password) {
        return usersService.checkUser(mail, password);
    }


    @CrossOrigin
    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        return usersService.createUser(user);
    }

    @CrossOrigin
    @GetMapping("/findUser")
    public User findUser(@RequestParam String token) {
        return usersService.getUserByToken(token);
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        usersService.deleteAll();
    }


    @CrossOrigin
    @GetMapping("/countData")
    public UserData countData(@RequestParam int userId) {
        return usersService.countData(userId);
    }


    @CrossOrigin
    @PostMapping("/changeProfilePic")
    public void changeProfilePic(@RequestBody String base64, @RequestHeader String token) {
        usersService.changeProfilePic(base64, token);
    }


    @CrossOrigin
    @GetMapping("/findAll")
    public ArrayList<User> findAllUsers(){
       return usersService.getUsers();
    }


    @CrossOrigin
    @PostMapping("/updateFriend")
    public Friend sendFriendRequest(@RequestBody Friend friend){
        return friendsService.updateFriend(friend);
    }

    @CrossOrigin
    @GetMapping("/getFriend")
    public Friend getFriend(@RequestParam int userId){
        return friendsService.getFriend(userId);
    }


}
