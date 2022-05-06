package com.kolvin.kplaform.controllers;

import com.kolvin.kplaform.models.TelcoUser;
import com.kolvin.kplaform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<TelcoUser> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(path = "add")
    public void addNewUser(@RequestBody TelcoUser user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "remove/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.removeUser(userId);
    }

    @PutMapping(path = "update/{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestParam(required = false) Integer status,
                           @RequestParam(required = false) String serviceProvider) {
        userService.updateUser(userId, status, serviceProvider);
    }
}
