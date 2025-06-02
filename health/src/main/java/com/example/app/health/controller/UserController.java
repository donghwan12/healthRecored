package com.example.app.health.controller;

import com.example.app.health.domain.User.Dto.UserDto;
import com.example.app.health.domain.User.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/join")
    public String join(Model model){
        log.info("Get/UserController/join...");
        model.addAttribute("UserDto", new UserDto());
        return "/user/join";
    }

    @PostMapping("/join")
    public String join_post(@ModelAttribute("UserDto") UserDto userDto, Model model){
        log.info("Post/UserController/join..." + userDto);
        userService.userjoin(userDto,model);
        return "home";
    }

}
