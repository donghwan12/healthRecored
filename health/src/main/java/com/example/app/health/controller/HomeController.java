package com.example.app.health.controller;

import com.example.app.health.domain.User.Dto.UserDto;
import com.example.app.health.domain.User.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping("/")
    public String home_post(@ModelAttribute("userDto")UserDto userDto){
        log.info("userDto : "+userDto);
        userService.UserLogin(userDto);
        return null;
    }
}
