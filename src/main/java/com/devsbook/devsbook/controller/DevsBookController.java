package com.devsbook.devsbook.controller;


import com.devsbook.devsbook.entity.User;
import com.devsbook.devsbook.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DevsBookController {

    UsersService usersService;

    @Autowired
    public DevsBookController(UsersService usersService) {
        this.usersService = usersService;
    }

    @CrossOrigin
    @GetMapping("/checkUser")
    public String checkUser(@RequestParam String mail, @RequestParam String password){
        return usersService.checkUser(mail,password);
    }


    @CrossOrigin
    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
          return usersService.createUser(user);
    }


    @GetMapping("/deleteAll")
    public void deleteAll(){
        usersService.deleteAll();
    }


}
