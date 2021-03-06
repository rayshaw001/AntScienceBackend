package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.LoginUser;
import com.as.backend.antscience.entity.User;
import com.as.backend.antscience.enums.Authority;
import com.as.backend.antscience.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class AccountController {

    @Resource(name = "userService")
    private UserService userService;

    String[] authorities = {Authority.GENERAL.toString()};

    @PostMapping("/register")
    public User register(@RequestBody @Valid LoginUser loginUser){
        User user  = new User();
        user.setUsername(loginUser.getIdentity());
        user.setPassword(loginUser.getPassword());
        user.setRoles(authorities);
        userService.createUser(user);
        return userService.findUserByUsername(loginUser.getIdentity());
    }

//    @PostMapping("/login")
//    public User login(@RequestBody @Valid LoginUser user){
//
//        return null;
//    }

}
